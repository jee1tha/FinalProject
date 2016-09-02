package businessOperationsLayer;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.encog.*;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.Propagation;
import org.encog.neural.networks.training.propagation.back.Backpropagation;
import org.encog.persist.EncogDirectoryPersistence;

import databaseLayer.DatabaseMethodsImpl;
import databaseLayer.Skills;
import databaseLayer.*;

public class NNSkillModelImpl implements NNModels {

	public static final String FILENAME = "skills_network.eg";

	private static final Logger log = Logger.getLogger(NNSkillModelImpl.class);

	public static void main(String[] args) {
		
		  NNSkillModelImpl g = new NNSkillModelImpl();
		  DatabaseMethodsImpl d = new  DatabaseMethodsImpl(); 
		  Applicants aa = new Applicants();
		  aa.setAppID(6);
		  
		  
	 g.trainAndSaveModel();
		  
		  System.out.println("Network Skills output: "+  g.loadAndEvaluateModel(aa) );
		 
	}

	public void trainAndSaveModel() {

		DatabaseMethodsImpl db = new DatabaseMethodsImpl();

		// getting skills with eligibility true

		Skills skill = new Skills();
		skill.setSeligibility(true);
		ResultSet skillsRS = null;
		skillsRS = db.getSkills(skill);

		// getting skills with eligibility false

		Skills skillFalse = new Skills();
		skillFalse.setSeligibility(false);
		ResultSet skillFalseRS = null;
		skillFalseRS = db.getSkills(skillFalse);

		int rowCal = 0; // calculating no of rows to initiate List
		try {
			while (skillsRS.next()) {
				rowCal++;
			}
			while (skillFalseRS.next()) {
				rowCal++;
			}
		} catch (SQLException e2) {

			log.debug("Failed to retrive Skills eligible", e2);
		}

		int count = rowCal / 5; // determining the list parent array size

		double SKILL_INPUT[][] = new double[count][5]; // 5 input neurons
		double SKILL_IDEAL[][] = new double[count][1]; // 1 input neuron
		// add retrieved skills to input and ideal out put arrays
		int j = 0;
		int i = 0;
		try {
			skillsRS.beforeFirst();
			while (skillsRS.next()) {

				if (i == 4) {
					SKILL_IDEAL[j][0] = 1.0;
				}

				String r = skillsRS.getString("sid");
				SKILL_INPUT[j][i] = Double.parseDouble(r) / 1000;
				i++;

				if (i > 4) {
					i = 0;

					j++;
				}
			}

			log.debug("Retrieved Skills eligible");

		} catch (SQLException e1) {

			log.debug("Failed to retrive Skills eligible", e1);
		}

		int z = 0;
		try {
			skillFalseRS.beforeFirst();
			while (skillFalseRS.next()) {

				if (z == 4) {
					SKILL_IDEAL[j][0] = (double) 0;
				}
				SKILL_INPUT[j][z] = Double.parseDouble(skillFalseRS.getString("sid")) / 1000;
				z++;
				if (z > 4) {
					z = 0;

					j++;
				}
			}
			log.debug("Retrieved Skills NOT eligible");

		} catch (SQLException e1) {

			log.debug("Failed to retrive Skills NOT eligible", e1);

		}

		System.out.println("Training skill model network under 1% error rate.");
		log.debug("Training skill model network under 1% error rate, 5 input neurons and 1 output neuron.");

		BasicNetwork networkSkills = new BasicNetwork();
		networkSkills.addLayer(new BasicLayer(5));
		networkSkills.addLayer(new BasicLayer(6));
		networkSkills.addLayer(new BasicLayer(1));
		networkSkills.getStructure().finalizeStructure();
		networkSkills.reset();

		// training data set

		try {
			MLDataSet trainingSet = new BasicMLDataSet(SKILL_INPUT, SKILL_IDEAL);
		
			final Propagation train = new Backpropagation(networkSkills, trainingSet);
			int epoch = 1;
			do {
				train.iteration();
				System.out.println("Epoch #" + epoch + " Error:" + train.getError() );
				epoch++;

			} while (train.getError() > 0.001);

			double e = networkSkills.calculateError(trainingSet);
			System.out.println("Network Skills trained to error :" + e);
			System.out.println("Saving Network (Skills) ");

			EncogDirectoryPersistence.saveObject(new File(FILENAME), networkSkills);
			log.debug("Training Skill Network success at Epoch #" + epoch);
		} catch (Exception e) {
			log.debug("Training Skill Network failed", e);
		}
	}

	public double loadAndEvaluateModel(Applicants app) {

		DatabaseMethodsImpl d = new DatabaseMethodsImpl();
		ResultSet rz = d.getApplicantSkills(app);
		double user[] = new double[5];
		try {
			int s = 0;
			while (rz.next()) {
				int w = rz.getInt("sid");
				user[s] = (double) w / 1000;
				s++;
			}
		} catch (SQLException e) {
			log.debug("Reading Skills of user from DB failed at loadandEvaluate Method", e);
		}
		System.out.println("Loading Network Skills ");
		BasicNetwork network = (BasicNetwork) EncogDirectoryPersistence.loadObject(new File(FILENAME));

		double[] output = new double[1];
		network.compute(user, output);

		return output[0];

	}
}
