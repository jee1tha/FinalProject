package businessOperationsLayer;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.encog.engine.network.activation.ActivationBiPolar;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.engine.network.activation.ActivationTANH;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.Propagation;
import org.encog.neural.networks.training.propagation.back.Backpropagation;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;
import org.encog.persist.EncogDirectoryPersistence;

import databaseLayer.Applicants;
import databaseLayer.DatabaseMethodsImpl;
import databaseLayer.Experience;
import databaseLayer.Qualifications;
public class NNQualificationsAndExperience implements NNModels{
	public static final String FILENAME = "qualifications_network.eg";

	private static final Logger log = Logger.getLogger(NNQualificationsModel.class);
	
	public static void main(String[] args) {
		NNQualificationsAndExperience b = new NNQualificationsAndExperience();
		
		//b.trainAndSaveModel();
		
		Applicants app = new Applicants();
		app.setAppID(6);
		
		System.out.println(b.loadAndEvaluateModel(app));
	}
	public void trainAndSaveModel() {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();

		// getting qualifications with eligibility true
		
		Qualifications qua = new Qualifications();
		qua.setQualificationsEligibility(true);
		ResultSet qualificationsTrue = db.getQualifications(qua);
		
		// getting experience with eligibility true
		
		Experience exp = new Experience();
		exp.setExeligibility(true);
		ResultSet experienceTrue = db.getExp(exp);
		
		// getting qualifications with eligibility false
		
		Qualifications quaF = new Qualifications();
		quaF.setQualificationsEligibility(false);
		ResultSet qualificationsFalse = db.getQualifications(quaF);
		
	// getting experience with eligibility false
		
		Experience expFalse = new Experience();
		expFalse.setExeligibility(false);
		ResultSet experienceFalse = db.getExp(expFalse);
		

		int rowCal = 0; // calculating no of rows to initiate List
		int rowCal2 = 0;
		try {
			while (qualificationsTrue.next()) {
				rowCal++;
			}
			while (qualificationsFalse.next()) {
				rowCal2++;
			}
	
		} catch (SQLException e2) {

			log.debug("Failed to retrive qualifications eligible", e2);
		}
		int count = (rowCal + rowCal2 ) *2   ;
		
		double QUALIFICATION_INPUT[][] = new double[count][2]; // 2 input neurons
		double QUALIFICATION_IDEAL[][] = new double[count][1]; // 1 input neuron
		
		// add retrieved qualifcations to input and ideal out put arrays
		int j = 0;
		int i = 0;
		
		try {
			qualificationsTrue.beforeFirst();
			experienceTrue.beforeFirst();
			while (qualificationsTrue.next() ) {
				boolean hasmore = false;
				if(experienceTrue.next() == true){
					hasmore=true;
				};
				if (i == 1) {
					
				}
				
				String r = qualificationsTrue.getString("eid");
				int e=0;
				if(hasmore==true){
				 e = experienceTrue.getInt("exid");
				}
				
				QUALIFICATION_INPUT[j][i] = Double.parseDouble(r) / 1000;
				int count4 = i +1;
				QUALIFICATION_INPUT[j][count4] = (double)e / 10000;
				i++;

				if (i == 1) {
					i = 0;
					QUALIFICATION_IDEAL[j][0] = 1.0;
					j++;
				}
				
			
				log.debug("Retrieved qualifcations eligible");
			}
		/*	{
				experienceTrue.beforeFirst();
				experienceTrue.next();
				if(QUALIFICATION_INPUT[j][i]== 0.0 && QUALIFICATION_INPUT[j][i-1] != 0.0){
				
					QUALIFICATION_INPUT[j][i]= Double.parseDouble(experienceTrue.getString("exid"))/ 10000;
					QUALIFICATION_INPUT[j][0]=0.0;
				
			}
*/			
		
			
		} catch( SQLException e){
			log.debug("Failed to retrieve qualifications eligible");
		}
			
		int z = 0;
		try {
			qualificationsFalse.beforeFirst();
			experienceFalse.beforeFirst();
			while (qualificationsFalse.next()) {
				boolean hasmore = false;
				if(experienceFalse.next() == true){
					hasmore=true;
				};
			
				
				int e=0;
				if(hasmore==true){
				 e = experienceFalse.getInt("exid");
				}
				QUALIFICATION_INPUT[j][z] = Double.parseDouble(qualificationsFalse.getString("eid")) / 1000;
				int count4 = z +1;
				QUALIFICATION_INPUT[j][count4] = (double)e / 10000;
				
				z++;
				if (z == 1) {
					z = 0;
					QUALIFICATION_IDEAL[j][0] = (double) 0;
					j++;
				}
			}
			log.debug("Retrieved qualifcations NOT eligible");

		} catch (SQLException e1) {

			log.debug("Failed to retrive qualifcations NOT eligible", e1);

		}	
		
		int a = 0;
		try {
			qualificationsFalse.beforeFirst();
			experienceTrue.beforeFirst();
			while (qualificationsFalse.next()) {
				boolean hasmore = false;
				if(experienceTrue.next() == true){
					hasmore=true;
				};
			
				
				int e=0;
				if(hasmore==true){
				 e = experienceTrue.getInt("exid");
				}
				QUALIFICATION_INPUT[j][a] = Double.parseDouble(qualificationsFalse.getString("eid")) / 1000;
				int count4 = a +1;
				QUALIFICATION_INPUT[j][count4] = (double)e / 10000;
				
				a++;
				if (a == 1) {
					a = 0;
					QUALIFICATION_IDEAL[j][0] = (double) 1;
					j++;
				}
			}
			log.debug("Retrieved qualifcations NOT eligible");

		} catch (SQLException e1) {

			log.debug("Failed to retrive qualifcations NOT eligible", e1);

		}
		
		int b = 0;
		try {
			qualificationsTrue.beforeFirst();
			experienceFalse.beforeFirst();
			while (qualificationsTrue.next()) {
				boolean hasmore = false;
				if(experienceFalse.next() == true){
					hasmore=true;
				};
			
				
				int e=0;
				if(hasmore==true){
				 e = experienceFalse.getInt("exid");
				}
				QUALIFICATION_INPUT[j][b] = Double.parseDouble(qualificationsTrue.getString("eid")) / 1000;
				int count4 = b +1;
				QUALIFICATION_INPUT[j][count4] = (double)e / 10000;
				
				b++;
				if (b == 1) {
					b = 0;
					QUALIFICATION_IDEAL[j][0] = (double) 0;
					j++;
				}
			}
			log.debug("Retrieved qualifcations NOT eligible");

		} catch (SQLException e1) {

			log.debug("Failed to retrive qualifcations NOT eligible", e1);

		}
		
		
		System.out.println("Training qualifcations model network under 1% error rate.");
		log.debug("Training qualifcations model network under 1% error rate, 2 input neurons and 1 output neuron.");

		BasicNetwork networkSkills = new BasicNetwork();
		networkSkills.addLayer(new BasicLayer(2));
		networkSkills.addLayer(new BasicLayer(3));
		networkSkills.addLayer(new BasicLayer(1));
		networkSkills.getStructure().finalizeStructure();
		networkSkills.reset();

		// training data set
	
		try {
			MLDataSet trainingSetQualifcation = new BasicMLDataSet(QUALIFICATION_INPUT, QUALIFICATION_IDEAL);
	//		final ResilientPropagation train = new ResilientPropagation(networkSkills, trainingSetQualifcation);
		final Propagation train = new Backpropagation(networkSkills, trainingSetQualifcation);
			int epoch = 1;
			do {
				train.iteration();
				System.out.println("Epoch #" + epoch + " Error:" + train.getError() );
				epoch++;

			} while (train.getError() > 0.2);

			double e = networkSkills.calculateError(trainingSetQualifcation);
			System.out.println("Network qualifcations trained to error :" + e);
			System.out.println("Saving Network (qualifcations) ");
		
			EncogDirectoryPersistence.saveObject(new File(FILENAME), networkSkills);
			log.debug("Training qualifcations Network success at Epoch #" + epoch);
		} catch (Exception e) {
			log.debug("Training qualifcations Network failed", e);
		}
	}

	public double loadAndEvaluateModel(Applicants app) {
		DatabaseMethodsImpl d = new DatabaseMethodsImpl();
		ResultSet rz = d.getApplicantQualifications(app);
		ResultSet exp = d.getApplicantExperience(app);
		double user[] = new double[2];
		try {
			
				
			while (rz.next()) {
				exp.next();
				int w = rz.getInt("eid");
				int e = exp.getInt("exid");
				user[0] = (double) w / 1000;
				
				user[1] = (double) e/10000 ;
				
			}
		} catch (SQLException e) {
			log.debug("Reading qualifications/experience of user from DB failed at loadandEvaluate Method", e);
		}
		System.out.println("Loading Network qualifications and experience ");
		BasicNetwork network = (BasicNetwork) EncogDirectoryPersistence.loadObject(new File(FILENAME));

		double[] output = new double[1];
		network.compute(user, output);

		return output[0];
	}
}
