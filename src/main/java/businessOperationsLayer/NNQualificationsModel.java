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

public class NNQualificationsModel implements NNModels{
	public static final String FILENAME = "qualifications_network.eg";

	private static final Logger log = Logger.getLogger(NNQualificationsModel.class);
	
	public static void main(String[] args) {
		NNQualificationsModel b = new NNQualificationsModel();
		
		b.trainAndSaveModel();
		
		Applicants app = new Applicants();
		app.setAppID(6);
		
		System.out.println(b.loadAndEvaluateModel(app));
	}
	public int trainAndSaveModel() {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();

		// getting qualifications with eligibility true
		
		Qualifications qua = new Qualifications();
		qua.setQualificationsEligibility(true);
		ResultSet qualificationsTrue = db.getQualifications(qua);
		

		// getting qualifications with eligibility false
		
		Qualifications quaF = new Qualifications();
		quaF.setQualificationsEligibility(false);
		ResultSet qualificationsFalse = db.getQualifications(quaF);
		


		int rowCal1 = 0; // calculating no of rows to initiate List
		int rowCal2 = 0;
		try {
			while (qualificationsTrue.next()) {
					rowCal1++;
			}
			while (qualificationsFalse.next()) {
					rowCal2++;
			}
		} catch (SQLException e1) {
			log.debug("Row count failed", e1);
		}
		int rowCal3= 0 ;
		int rowCal4=0;
		rowCal3 = rowCal1/ 2;
		if(rowCal1%2 !=0){
			rowCal3++;
		}
		rowCal4 = rowCal2/ 2;
		if(rowCal2%2 !=0){
			rowCal4++;
		}
		int count = rowCal3 + rowCal4 ;
		double EXP_INPUT[][] = new double[count][2]; // 2 input neurons
		double EXP_IDEAL[][] = new double[count][1]; // 1 input neuron
		int j = 0;
		int i = 0;
		try {
			qualificationsTrue.beforeFirst();
			while(qualificationsTrue.next()){
				if(i>1){
					i=0;
				}
				EXP_INPUT[j][i] = Double.parseDouble(qualificationsTrue.getString("eid")) / 1000;
				
				if(i == 1){
					 EXP_IDEAL[j][0]=1.0;
					j++;
				}
				i++;
			
			}	
			qualificationsTrue.beforeFirst();
			qualificationsTrue.next();
			{
				if(EXP_INPUT[j][1]== 0.0 && EXP_INPUT[j][0] != 0.0){
				
				EXP_INPUT[j][1]= Double.parseDouble(qualificationsTrue.getString("eid"))/ 1000;
				
				 EXP_IDEAL[j][0]=1.0;
				 j++;
			}
				
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			i=0;
			qualificationsFalse.beforeFirst();
			while(qualificationsFalse.next()){
				if(i>1){
					i=0;
				}
				EXP_INPUT[j][i] = Double.parseDouble(qualificationsFalse.getString("eid")) / 1000;
				
				if(i == 1){
					 EXP_IDEAL[j][0]=0.0;
					j++;
				}
				i++;
			
			}	
			qualificationsFalse.beforeFirst();
			qualificationsFalse.next();
			{if(j<count){
				if(EXP_INPUT[j][1]== 0.0 && EXP_INPUT[j][0] != 0.0){
				
				EXP_INPUT[j][i]= Double.parseDouble(qualificationsFalse.getString("eid"))/ 1000;
				 EXP_IDEAL[j][0]=0.0;
			}
			}}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	System.out.println("Training Experience model network under 1% error rate.");
	log.debug("Training Experience model network under 1% error rate, 2 input neurons and 1 output neuron.");

	BasicNetwork networkSkills = new BasicNetwork();
	networkSkills.addLayer(new BasicLayer(2));
	networkSkills.addLayer(new BasicLayer(6));
	networkSkills.addLayer(new BasicLayer( 1));
	networkSkills.getStructure().finalizeStructure();
	networkSkills.reset();

	// training data set
	double QUALIFICATION_INPUT1[][] = {{1.0} ,{1.0},  {0.0} , {0.0} , {1.0} } ;
	double QUALIFICATION_IDEAL1[][] = {{0.001, 0.00001}, {0.002, 0.00003}, {0.003, 0.00004}, {0.004, 0.00005}, {0.003, 0.00002}} ;
	try {
		MLDataSet trainingSetQualifcation = new BasicMLDataSet(EXP_INPUT, EXP_IDEAL);
		final Propagation train = new Backpropagation(networkSkills, trainingSetQualifcation);
		int epoch = 1;
		do {
			train.iteration();
			System.out.println("Epoch #" + epoch + " Error:" + train.getError() );
			epoch++;

		} while (train.getError() > 0.001);

		double e = networkSkills.calculateError(trainingSetQualifcation);
		System.out.println("Network Experience trained to error :" + e);
		System.out.println("Saving Network (Experience) ");
	
		EncogDirectoryPersistence.saveObject(new File(FILENAME), networkSkills);
		log.debug("Training Experience Network success at Epoch #" + epoch);
	} catch (Exception e) {
		log.debug("Training Experience Network failed", e);
	}
	
	return 1;
	}

	public double loadAndEvaluateModel(Applicants app) {
		DatabaseMethodsImpl d = new DatabaseMethodsImpl();
		ResultSet exp = d.getApplicantExperience(app);
		double user[] = new double[2];
		try {
			int r = 0;
				
			while (exp.next()) {
				
			
				int e = exp.getInt("exid");
				
				
				user[r] = (double) e/1000 ;
				r++;
				
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
