package businessOperationsLayer;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

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

public class NNSkillModel {

	public static double SKILL_INPUT[][] = { {1},{2},{4},{5},{1},{3},{2} } ;
	public static double SKILL_IDEAL[][] ;
	
	public static double USER_INPUT[][] ;

	public static double XOR_INPUT2[] ;
	
	public static final String FILENAME = "skills_network.eg";
	
	private static final Logger log = Logger.getLogger(NNSkillModel.class);
	
	public static void main(String[] args) {
		NNSkillModel g = new NNSkillModel();
		g.trainAndSaveSkillsModel();
		g.loadAndEvaluate();
	}
	
	public void trainAndSaveSkillsModel(){
		
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		Skills skill = new Skills();
		
		
		// getting skills with eligibility true
		
		skill.setSeligibility(true);
		
		
		ResultSet skillsRS = null;
		skillsRS = db.getSkills(skill);
		
		// add retrieved skills to input and ideal out put arrays
		int j = 0 ;
		
		try {
			while(skillsRS.next()){
				int i = 0 ;
				
				
				if(i>4){
					i =0;
					
					SKILL_IDEAL[j][i] = 1.0;
					
					j++;
				}
				
				SKILL_INPUT[j][i] = Double.parseDouble(skillsRS.getString("sid")) / 1000 ;
				
				i++;
			}
			
			log.debug("Retrieved Skills eligible");
			
		} catch (SQLException e1) {
			
			log.debug("Failed to retrive Skills eligible",e1);
		}
		
		
		// Retrieving skills with eligibility false 
		
		Skills skillFalse = new Skills();
		
		// getting skills with eligibility false
		
		skillFalse.setSeligibility(false);
		
		ResultSet skillFalseRS = null;
		
		skillFalseRS = db.getSkills(skillFalse) ;
		
		try {
			while(skillFalseRS.next()){
				int i = 0 ;
				if(i>4){
					i =0;
					SKILL_IDEAL[j][i] = 0;
					j++;
				}
					SKILL_INPUT[j][i] = Double.parseDouble(skillFalseRS.getString("sid")) / 1000;
					i++;
				}
			log.debug("Retrieved Skills NOT eligible");
			
			} catch (SQLException e1) {
				
			log.debug("Failed to retrive Skills NOT eligible",e1);
			
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
		
		try{
		MLDataSet trainingSet = new BasicMLDataSet(SKILL_INPUT, SKILL_IDEAL);
		
		final Propagation  train =  new Backpropagation(networkSkills, trainingSet);
		int epoch = 1;
		do {
			train.iteration();
			System.out.println("Epoch #" + epoch + 
                    " Error:" + train.getError());
					epoch++;

		} while (train.getError() > 0.001);
		
		double e = networkSkills.calculateError(trainingSet);
		System.out.println("Network Skills trained to error :" + e);
		System.out.println("Saving Network (Skills) ");
		
		
		EncogDirectoryPersistence.saveObject(new File(FILENAME), networkSkills);
	}catch (Exception e){
		log.debug("Training Skill Network failed",e);
	}
	}
	
	public void loadAndEvaluate(){
		System.out.println("Loading Network Skills ");
		BasicNetwork network = (BasicNetwork) EncogDirectoryPersistence.loadObject(new File(FILENAME));
		
		double[] output = new double[1];
		network.compute(XOR_INPUT2, output);
	    System.out.println("Network Skills output: " + output[0] + " (should be close to 0.0)");

		
	}
}
