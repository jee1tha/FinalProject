package businessOperationsLayer;

import java.util.ArrayList;

import org.apache.log4j.Logger;



import databaseLayer.Applicants;
import databaseLayer.DatabaseMethodsImpl;
import databaseLayer.Experience;
import databaseLayer.Qualifications;
import databaseLayer.Skills;

public class DEMOSTRATION_CLASS {
	 private static final Logger log = Logger.getLogger(DEMOSTRATION_CLASS.class);

	public static void main(String[] args) {
//	NNQualificationsAndExperienceImpl b = new NNQualificationsAndExperienceImpl();
		
		//b.trainAndSaveModel();
	/*	int[] applicants =  new int[10];
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
	
	*/
//	BOLMethodsImpl bz = new BOLMethodsImpl();
//	bz.trainQualificationsExperienceNN();
		// SKILLS TESTING
	/*	NNSkillModelImpl g = new NNSkillModelImpl();
		 g.trainAndSaveModel();*/
		/*int[] applicant =  new int[10];
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
				score2[i]=g.loadAndEvaluateModel(aa);
				}
			for(int i =0; i<10 ;i++){
				
				System.out.println(score2[i]);
				} 
	
		  
	BOLMethodsImpl z = new BOLMethodsImpl();
	Applicants ap = new Applicants();
	ap.setAppID(3);
	z.evaluateApplicant(ap);*/
/*	for(int i = 0 ; i <z.getApplicantSkills(ap).size(); i++){
		System.out.println(	z.getApplicantSkills(ap).get(i).getSkill());
		System.out.println(z.getApplicantSkills(ap).get(i).getSeligibility());
		System.out.println(	z.getApplicantSkills(ap).get(i).getSkillID());

	

	}*/
/*		BOLMethodsImpl n  = new BOLMethodsImpl();
		Skills sk = new  Skills();
		ArrayList<String> array = new ArrayList<String>();
		array.add("boostrap");
		array.add("css");
		array.add("java");
		array.add("grunt");
		array.add("gulp");
		
		sk.setSkillName(array);
		
		Applicants app = new Applicants();
		app.setAppID(13);
		n.addUserSkills(app, sk);*/
	 
/*	 BOLMethodsImpl n  = new BOLMethodsImpl();
	 Applicants ap = new Applicants();
	 ap.setAppID(13);
	 
	 Qualifications q = new Qualifications();
	 q.setName("HND");
	 q.setInstitute("ICBT");
	 q.setqClass("Distinction");
	 
	 
	 System.out.println(n.addUserQualifications(ap, q));*/
		
 BOLMethodsImpl n  = new BOLMethodsImpl();
 /*	double z = n.getUserEvaluationAll().get(0).finalScore;
	System.out.println(z);*/
	/* Applicants ap = new Applicants();
	 ap.setAppID(45);*/
	// System.out.print(n.evaluateApplicant(ap));
	
	// n.trainSkillsNN();
	 /*Experience a = new Experience();
	 a.setOrganization("Lentons");
	 a.setPost("Intern Software Developer");
	 a.setDuration(2);
	 
	 n.addUserExperience(ap, a);*/
 
  /*   for(int i = 0; i< n.getSkillAll().size()  ; i++){
    	 System.out.println(n.getSkillAll().get(i).getSkill());
     }*/
 
 System.out.println(n.evaluateAllApplicants());
	}
}
