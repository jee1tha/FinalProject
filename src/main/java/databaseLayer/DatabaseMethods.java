package databaseLayer;

import java.util.ArrayList;

public interface DatabaseMethods {
	
	public int addApplicant(Applicants app);
	
	public int addAdmin(Admin admin);
	
	public int addSkills(Applicants app, Skills skill);
	
	public boolean checkApplicantUsername(Applicants app);
	
	public ArrayList<Admin> getAdminDetails(Admin admin);
	
	public ArrayList<Skills> getSkillDetails(Applicants app);
}
