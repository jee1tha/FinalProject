package businessOperationsLayer;

import databaseLayer.Applicants;
import databaseLayer.DatabaseMethodsImpl;

public class DEMOSTRATION_CLASS {
 public static void main(String[] args) {
	
	NNQualificationsAndExperience b = new NNQualificationsAndExperience();
		
		//b.trainAndSaveModel();
		int[] applicants =  new int[10];
		applicants[1] = 3;
		applicants[2] = 5;
		applicants[3] = 6;
		applicants[4] = 7;
		applicants[5] = 8;
		applicants[6] = 11;
		applicants[7] = 13;
		applicants[8] = 14;
		applicants[9] = 15;
		
		double[] score =  new double[10];
		Applicants app = new Applicants();
		for(int i =1; i<10 ;i++){
		app.setAppID(applicants[i]);
		score[i]=b.loadAndEvaluateModel(app);
		}
		for(int i =1; i<10 ;i++){
			
			System.out.println(score[i]);
			}
		// SKILLS TESTING
		// g.trainAndSaveModel();
		int[] applicant =  new int[10];
		applicant[0] = 3;
		applicant[1] = 5;
		applicant[2] = 6;
		applicant[3] = 7;
		applicant[4] = 8;
		applicant[5] = 11;
		applicant[6] = 13;
		applicant[7] = 14;
		applicant[8] = 15;
		applicant[9]= 16;
		
		
		
		  Applicants aa = new Applicants();
		  double[] score2 =  new double[10];
		  for(int i =0; i<10 ;i++){
			  aa.setAppID(applicant[i]);
				score2[i]=b.loadAndEvaluateModel(aa);
				}
			for(int i =0; i<10 ;i++){
				
				System.out.println(score2[i]);
				} 
	
		  
		  
		
}
}
