package businessOperationsLayer;

import java.util.ArrayList;

import databaseLayer.Admin;
import databaseLayer.Applicants;
import databaseLayer.Experience;
import databaseLayer.Job;
import databaseLayer.Qualifications;
import databaseLayer.Skills;

public interface BOLMethods {
 
	public int RegisterUser(Applicants app);
	
	public int RegisterAdmin(Admin admin);
	
	public int deleteAdmins(Admin admin);
	
	public int deleteUsers(Applicants app);
	
	public int LoginUser(Applicants app);
	
	public int LoginAdmin(Admin admin);
	
	public int addSkills(Skills skill);
	
	public int addExperience(Experience exp);
	
	public int addQualifications(Qualifications qualification);
	
	public int addJob(Job job);
	
	public int updateSkills(Skills skill);
	
	public int updateExperience(Experience exp);
	
	public int updateQualifications(Qualifications qualification);
	
	public ArrayList<Applicants> getApplicants(Applicants app);
	
	public ArrayList<Job> getJobInfo(Job job);
	
	public ArrayList<Admin> getAdminInfo(Admin admin);
	
	public ArrayList<Job> getUserJobInfo(Applicants app);
	
	
	public ArrayList<Skills> getSkillInfo(Skills skill);
	
	public ArrayList<Experience> getExpInfo(Experience exp);
	
	public ArrayList<Qualifications> getQualificationsInfo(Qualifications qualification);
	
	public ArrayList<Skills> getApplicantSkills(Applicants app);
	
	public ArrayList<Experience> getApplicantExp(Applicants app);
	
	public ArrayList<Qualifications> getApplicantQualifications(Applicants app);
	
	
	public void trainSkillsNN();
	
	public void trainQualificationsExperienceNN();
	
	public int evaluateApplicant(Applicants app);
	
	
	public int deleteskill( Skills skill);
	
	public int deleteExp(Experience exp);
	
	public int deleteQualifications(Qualifications qualifications);
	
	public int deleteJob( Job job);
        
        
	public int addUserJob(Applicants app, Job job);
        
	public int addUserSkills(Applicants app,Skills skill);
        
	public int addUserQualifications(Applicants app, Qualifications qua);
	
	public int addUserExperience(Applicants app, Experience exp);
	
	
}
