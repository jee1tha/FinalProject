package databaseLayer;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface DatabaseMethods {
	
	public int addApplicant(Applicants app);
	
	public int addAdmin(Admin admin);
	
	public int addJob(Job job);
	
	
	public ResultSet getApplicantDetails(Applicants app); // pass applicant id or username
	
	public ResultSet getAdminDetails(Admin admin); // pass admin username or id
	
	public ResultSet getJobDetails(Job job); // pass job id or name
	
	
	public int deleteApplicant(Applicants app);
	
	public int deleteAdmin(Admin admin);
	
	public int deleteSuperAdmin(Admin admin);
	
	public int deleteJob(Job job);
	
	
	public int addSkills( Skills skill);
	
	public int addExp(Experience exp);
	
	public int addQualifications(Qualifications qualification);
	
	
	public ResultSet getSkills(Skills skill);
	
	public ResultSet getExp(Experience exp);
	
	public ResultSet getQualifications(Qualifications qualification);
	
	
	public int updateSkills(Skills skill); //update skill eligibility
	
	public int updateExp(Experience exp);
	
	public int updateQualifications(Qualifications qualifications);
	
	
	public int addApplicantSkills(Applicants app, Skills skill);
	
	public int addApplicantExp(Applicants app, Experience exp);
	
	public int addApplicantQualifcations(Applicants app, Qualifications qualification);
	
	public int addApplicantJob(Applicants app,Job job);
	
	
	public boolean checkApplicantUsername(Applicants app);
	
	public boolean checkAdminUsername(Admin app);
	
	public ResultSet getUserJobStatus(Applicants app);
	
	public ResultSet getApplicantQualifications(Applicants app);
	
	public ResultSet getApplicantSkills(Applicants app);
	
	public ResultSet getApplicantExperience(Applicants app);
	
	
}
