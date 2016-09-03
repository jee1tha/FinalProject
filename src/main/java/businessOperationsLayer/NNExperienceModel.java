package businessOperationsLayer;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
import databaseLayer.Experience;

public class NNExperienceModel implements NNModels {
	public static final String FILENAME = "experience_network.eg";
	private static final Logger log = Logger.getLogger(DatabaseMethodsImpl.class);
	public static void main(String[] args) {
	
		NNExperienceModel b = new NNExperienceModel();
		b.trainAndSaveModel() ;
		Applicants app = new Applicants();
		app.setAppID(6);
		
		System.out.println(b.loadAndEvaluateModel(app));
	}
	public void trainAndSaveModel()  {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		
		// getting experience with eligibility true
		
		Experience exp = new Experience();
		exp.setExeligibility(true);
		ResultSet experienceTrue = db.getExp(exp);
		
		// getting experience with eligibility false
				
		Experience expFalse = new Experience();
		expFalse.setExeligibility(false);
		ResultSet experienceFalse = db.getExp(expFalse);
				
		int rowCal1 = 0; // calculating no of rows to initiate List
		int rowCal2 = 0;
		try {
			while (experienceTrue.next()) {
					rowCal1++;
			}
			while (experienceFalse.next()) {
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
			experienceTrue.beforeFirst();
			while(experienceTrue.next()){
				if(i>1){
					i=0;
				}
				EXP_INPUT[j][i] = Double.parseDouble(experienceTrue.getString("exid")) / 1000;
				
				if(i == 1){
					 EXP_IDEAL[j][0]=1.0;
					j++;
				}
				i++;
			
			}	
			experienceTrue.beforeFirst();
			experienceTrue.next();
			{
				if(EXP_INPUT[j][i]== 0.0 && EXP_INPUT[j][i-1] != 0.0){
				
				EXP_INPUT[j][i]= Double.parseDouble(experienceTrue.getString("exid"))/ 1000;
				
				 EXP_IDEAL[j][0]=1.0;
				 j++;
			}
				
			}
			 
		} catch (SQLException e1) {
			log.debug("adding experience valid to train array", e1);
		}
		
		try {
			i=0;
			experienceFalse.beforeFirst();
			while(experienceFalse.next()){
				if(i>1){
					i=0;
				}
				EXP_INPUT[j][i] = Double.parseDouble(experienceFalse.getString("exid")) / 1000;
				
				if(i == 1){
					 EXP_IDEAL[j][0]=0.0;
					j++;
				}
				i++;
			
			}	
			experienceFalse.beforeFirst();
			experienceFalse.next();
			{
				if(EXP_INPUT[j][i]== 0.0 && EXP_INPUT[j][i-1] != 0.0){
				
				EXP_INPUT[j][i]= Double.parseDouble(experienceFalse.getString("exid"))/ 1000;
				 EXP_IDEAL[j][0]=0.0;
				
			}
			}
		} catch (SQLException e1) {
			log.debug("adding experience invalid to train array", e1);
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
	/*double QUALIFICATION_INPUT1[][] = {{1.0} ,{1.0},  {0.0} , {0.0} , {1.0} } ;
	double QUALIFICATION_IDEAL1[][] = {{0.001, 0.00001}, {0.002, 0.00003}, {0.003, 0.00004}, {0.004, 0.00005}, {0.003, 0.00002}} ;*/
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
			user[0] = (double) w / 100;
			
			user[1] = (double) e/1000 ;
			
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
