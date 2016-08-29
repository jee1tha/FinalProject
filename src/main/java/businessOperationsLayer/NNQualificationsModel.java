package businessOperationsLayer;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.Propagation;
import org.encog.neural.networks.training.propagation.back.Backpropagation;
import org.encog.persist.EncogDirectoryPersistence;

import databaseLayer.Applicants;
import databaseLayer.DatabaseMethodsImpl;
import databaseLayer.Qualifications;

public class NNQualificationsModel implements NNModels{
	public static final String FILENAME = "qualifications_network.eg";

	private static final Logger log = Logger.getLogger(NNQualificationsModel.class);
	
	public static void main(String[] args) {
		/*NNQualificationsModel b = new NNQualificationsModel();
		
		b.trainAndSaveModel();
		
		Applicants app = new Applicants();
		app.setAppID(5);
		
		System.out.println(b.loadAndEvaluateModel(app));*/
	}
	public void trainAndSaveModel() {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();

		// getting qualifications with eligibility true
		
		Qualifications qua = new Qualifications();
		qua.setQualificationsEligibility(true);
		ResultSet qualifcationsTrue = db.getQualifications(qua);
		
		// getting qualifications with eligibility false
		
		Qualifications quaF = new Qualifications();
		quaF.setQualificationsEligibility(false);
		ResultSet qualifcationsFalse = db.getQualifications(quaF);
		

		int rowCal = 0; // calculating no of rows to initiate List
		int rowCal2=0;
		try {
			while (qualifcationsTrue.next()) {
				rowCal++;
			}
			while (qualifcationsFalse.next()) {
				rowCal2++;
			}
	
		} catch (SQLException e2) {

			log.debug("Failed to retrive qualifications eligible", e2);
		}
		int count1  = rowCal / 2; // determining the list parent array size // 
		int count2 = rowCal2 / 2 ;
		if(rowCal % 2 != 0){
			count1++ ;
		}
		if(rowCal2 % 2 != 0){
			count2++;
		}
		int count = count1 + count2 ;
		
		double QUALIFICATION_INPUT[][] = new double[count][2]; // 2 input neurons
		double QUALIFICATION_IDEAL[][] = new double[count][1]; // 1 input neuron
		
		// add retrieved qualifcations to input and ideal out put arrays
		int j = 0;
		int i = 0;
		try {
			qualifcationsTrue.beforeFirst();
			while (qualifcationsTrue.next()) {

				if (i == 1) {
					QUALIFICATION_IDEAL[j][0] = 1.0;
				}

				String r = qualifcationsTrue.getString("eid");
				QUALIFICATION_INPUT[j][i] = Double.parseDouble(r) / 1000;
				i++;

				if (i > 1) {
					i = 0;

					j++;
				}
				log.debug("Retrieved qualifcations eligible");
			}
	
			
		} catch( SQLException e){
			log.debug("Failed to retrieve qualifications eligible");
		}
			
		int z = 0;
		try {
			qualifcationsFalse.beforeFirst();
			while (qualifcationsFalse.next()) {

				if (z == 1) {
					QUALIFICATION_IDEAL[j][0] = (double) 0;
				}
				QUALIFICATION_INPUT[j][z] = Double.parseDouble(qualifcationsFalse.getString("eid")) / 1000;
				z++;
				if (z > 1) {
					z = 0;

					j++;
				}
			}
			log.debug("Retrieved qualifcations NOT eligible");

		} catch (SQLException e1) {

			log.debug("Failed to retrive qualifcations NOT eligible", e1);

		}	
		
		System.out.println("Training qualifcations model network under 1% error rate.");
		log.debug("Training qualifcations model network under 1% error rate, 2 input neurons and 1 output neuron.");

		BasicNetwork networkqualifications = new BasicNetwork();
		networkqualifications.addLayer(new BasicLayer(2));
		networkqualifications.addLayer(new BasicLayer(2));
		networkqualifications.addLayer(new BasicLayer(1));
		networkqualifications.getStructure().finalizeStructure();
		networkqualifications.reset();

		// training data set

		try {
			MLDataSet trainingSetQualifcation = new BasicMLDataSet(QUALIFICATION_INPUT, QUALIFICATION_IDEAL);

			final Propagation train = new Backpropagation(networkqualifications, trainingSetQualifcation);
			int epoch = 1;
			do {
				train.iteration();
				System.out.println("Epoch #" + epoch + " Error:" + train.getError());
				epoch++;

			} while (train.getError() > 0.001);

			double e = networkqualifications.calculateError(trainingSetQualifcation);
			System.out.println("Network qualifcations trained to error :" + e);
			System.out.println("Saving Network (qualifcations) ");

			EncogDirectoryPersistence.saveObject(new File(FILENAME), networkqualifications);
			log.debug("Training qualifcations Network success at Epoch #" + epoch);
		} catch (Exception e) {
			log.debug("Training qualifcations Network failed", e);
		}
	}

	public double loadAndEvaluateModel(Applicants app) {
		DatabaseMethodsImpl d = new DatabaseMethodsImpl();
		ResultSet rz = d.getApplicantQualifications(app);
		double user[] = new double[2];
		try {
			int s = 0;
			while (rz.next()) {
				int w = rz.getInt("eid");
				user[s] = (double) w / 1000;
				s++;
			}
		} catch (SQLException e) {
			log.debug("Reading qualifications of user from DB failed at loadandEvaluate Method", e);
		}
		System.out.println("Loading Network qualifications ");
		BasicNetwork network = (BasicNetwork) EncogDirectoryPersistence.loadObject(new File(FILENAME));

		double[] output = new double[1];
		network.compute(user, output);

		return output[0];
	}

}
