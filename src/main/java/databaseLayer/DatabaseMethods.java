package databaseLayer;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface DatabaseMethods {
	
	public int addApplicant(Applicants app); // add applicant
	
	public int addAdmin(Admin admin); // add admin 
	
	public int addJob(Job job); // add job
	
	
	public ResultSet getApplicantDetails(Applicants app); // pass applicant id or username to get applicant details
	
	public ResultSet getAdminDetails(Admin admin); // pass admin username or id to get admin details
	
	public ResultSet getJobDetails(Job job); // pass job id or name to get job details
	
	
	public int deleteApplicant(Applicants app); // delete applicant account
	
	public int deleteAdmin(Admin admin); // delete admin account
	
	public int deleteJob(Job job); // delete job
	
	
	public int addSkills( Skills skill); // adding skill
	
	public int addExp(Experience exp); // adding experience
	
	public int addQualifications(Qualifications qualification); // adding qualifications
	
	public int updateEvaluatedApplicant(Applicants app, Job job);
	
	public ResultSet getSkills(Skills skill); // get skills
	
	public ResultSet getExp(Experience exp); // get experience
	
	public ResultSet getQualifications(Qualifications qualification); // get qualifcations
	
	public ResultSet checkUserJob(Applicants app,Job job) ;
	
	public ResultSet getSkillAll();

	public ResultSet getExpAll();

	public ResultSet getQualificationsAll();
	
	
	public int updateSkills(Skills skill); //update skill eligibility
	
	public int updateExp(Experience exp); // update Experience
	
	public int updateQualifications(Qualifications qualifications); // update qualifications
	
	
	public int deleteskill( Skills skill) ;  // delete skill
	
	public int deleteExp(Experience exp); // delete experience
	
	public int deleteQualifications(Qualifications qualifications); // delete qualifcation
	
	
	
	
	public int addApplicantSkills(Applicants app, Skills skill); // adding applicant skills
	
	public int addApplicantExp(Applicants app, Experience exp); // adding applicant experience
	
	public int addApplicantQualifcations(Applicants app, Qualifications qualification); // Adding applicant qualifications
	
	public int addApplicantJob(Applicants app,Job job); // adding Applicant information to Job
	
	
	public boolean checkUsername(Users user); // checking for existing users with the same username
	
	public String login(Users user); // User login
	
	
	public ResultSet getUserJobStatus(Applicants app); // get user's job evaluation
	
	public ResultSet getApplicantQualifications(Applicants app); // get applicant's qualifications
	 
	public ResultSet getApplicantSkills(Applicants app); // get applicant's skills
	
	public ResultSet getApplicantExperience(Applicants app); // get applicant's experience
	
	public ResultSet getUserEvaluationAll();// get all users' evaluation 
	
}
