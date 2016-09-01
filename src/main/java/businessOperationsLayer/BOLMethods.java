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
	
	public int LoginUser(Applicants app);
	
	public int LoginAdmin(Admin admin);
	
	public int addSkills(Skills skill);
	
	public int addExperience(Experience exp);
	
	public int addQualifications(Qualifications qualification);
	
	public int updateSkills(Skills skill);
	
	public int updateExperience(Experience exp);
	
	public int updateQualifications(Qualifications qualification);
	
	public ArrayList<Applicants> getApplicants(Applicants app);
	
	public ArrayList<Job> getJobInfo(Job job);
	
	public ArrayList<Admin> getAdminInfo(Job job);
	
	public ArrayList<Job> getUserJobInfo(Applicants app);
	
	public void trainSkillsNN();
	
	public void trainQualificationsExperienceNN();
	
	public int evaluateSkills(Applicants app);
	
	public int evaluateQualificationsExperience(Applicants app);
	
	
	
}
