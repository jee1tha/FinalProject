package businessOperationsLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import databaseLayer.Admin;
import databaseLayer.Applicants;
import databaseLayer.DatabaseMethodsImpl;
import databaseLayer.Experience;
import databaseLayer.Job;
import databaseLayer.Qualifications;
import databaseLayer.Skills;

public class BOLMethodsImpl implements BOLMethods{
	
	private static final Logger log = Logger.getLogger(BOLMethodsImpl.class);
	
	public int RegisterUser(Applicants app) {
		int result = 0;
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		if(db.checkApplicantUsername(app) == false){
			result = db.addApplicant(app);
		}
		
		return result;
	}

	public int RegisterAdmin(Admin admin) {
		int result = 0;
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		if(db.checkAdminUsername(admin)==false){
			result = db.addAdmin(admin); 
		}
		return result;
	}

	public int LoginUser(Applicants app) {
		int result = 0;
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet rs = db.getApplicantDetails(app);
		try {
			if(rs.next()){
				result = 1;
				log.debug("Login applicant found" );
			}
		} catch (SQLException e) {
			
			log.debug("Login applicant  failed : ", e);
		}
		return result;
	}

	public int LoginAdmin(Admin admin) {
		int result = 0;
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet rs = db.getAdminDetails(admin);
		try {
			if(rs.next()){
				result = 1;
				log.debug("Login admin found" );
			}
			
		} catch (SQLException e) {
			
			log.debug("Login admin  failed : ", e);
		}
		return result;
	}

	public int addSkills(Skills skill) {
		int result = 0;
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet rs = db.getSkills(skill);
		
		try {
			boolean z = rs.next() ;
			if(rs.next()==false){
				result = db.addSkills(skill);
				log.debug("New Skill Added" );
			}
			
			
		} catch (SQLException e) {
			
			log.debug("add Skills  failed : ", e);
		}
		return result;
	}

	public int addExperience(Experience exp) {
		int result = 0;
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet rs = db.getExp(exp);
		try {
			if(rs.next()==false){
				result = db.addExp(exp);
				log.debug("New Experience Added" );
			}
			
			
		} catch (SQLException e) {
			
			log.debug("add Experience  failed : ", e);
		}
		return result;
	}

	public int addQualifications(Qualifications qualification) {
		int result = 0;
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet rs = db.getQualifications(qualification);
		try {
			if(rs.next()==false){
				result = db.addQualifications(qualification);
				log.debug("New Experience Added" );
			}
			
			
		} catch (SQLException e) {
			
			log.debug("add Qualifications  failed : ", e);
		}
		return result;
	}

	public int updateSkills(Skills skill) {
		int result = 0;
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		
		try {
			
			result = db.updateSkills(skill);
			
		} catch (Exception e) {
			
			log.debug("update skill  failed : ", e);
		}
		return result;
	}

	public int updateExperience(Experience exp) {
		int result = 0;
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		
		try {
			
			result = db.updateExp(exp);
			
		} catch (Exception e) {
			
			log.debug("update Experience failed : ", e);
		}
		return result;
	}

	public int updateQualifications(Qualifications qualification) {
		int result = 0;
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		
		try {
			
			result = db.updateQualifications(qualification);
			
		} catch (Exception e) {
			
			log.debug("update Qualifications failed : ", e);
		}
		return result;
	}

	public ArrayList<Applicants> getApplicants(Applicants app) {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet rs= db.getApplicantDetails(app);
		
		ArrayList<Applicants> appArray = new ArrayList<Applicants>();
		
		try {
			while(rs.next()){
				Applicants ap = new Applicants();
				ap.setAppID(rs.getInt("id"));
				ap.setBirthDate(rs.getString("birthday"));
				ap.setContactNo(rs.getString("contactno"));
				ap.setEmail(rs.getString("email"));
				ap.setName(rs.getString("name"));
				ap.setNicNo(rs.getString("nicno"));
				ap.setPassword(rs.getString("password"));
				ap.setRole(rs.getString("role"));
				ap.setUsername(rs.getString("username"));
				
			appArray.add(ap) ;
			}
		} catch (SQLException e) {
			
			log.debug("Get applicants failed : ", e);
		}
		return appArray;
	}

	public ArrayList<Job> getJobInfo(Job job) {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet rs= db.getJobDetails(job);
		
		ArrayList<Job> jobArray = new ArrayList<Job>();
		
		try {
			while(rs.next()){
				Job ap = new Job();
				ap.setJobDescription(rs.getString("description"));
				ap.setName(rs.getString("name"));
				ap.setJobid(rs.getInt("jid"));
				
				
				jobArray.add(ap) ;
			}
		} catch (SQLException e) {
			
			log.debug("Get jobinfo failed : ", e);
		}
		return jobArray;
	}

	public ArrayList<Admin> getAdminInfo(Admin admin) {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet rs= db.getAdminDetails(admin);
		
		ArrayList<Admin> adminArray = new ArrayList<Admin>();
		
		try {
			while(rs.next()){
				Admin ap = new Admin();
				ap.setAdminID(rs.getInt("id"));
				ap.setContactNo(rs.getString("contactno"));
				ap.setEmail(rs.getString("email"));
				ap.setName(rs.getString("name"));
				ap.setEmpNo(rs.getString("empno"));
				ap.setPassword(rs.getString("password"));
				ap.setRole(rs.getString("role"));
				ap.setUsername(rs.getString("username"));
				
				adminArray.add(ap) ;
			}
		} catch (SQLException e) {
			
			log.debug("Get applicants failed : ", e);
		}
		return adminArray;
	}



	public int deleteAdmins(Admin admin) {
		DatabaseMethodsImpl db = new  DatabaseMethodsImpl();
		
		return db.deleteAdmin(admin);
	}
	public int deleteUsers(Applicants app){
		DatabaseMethodsImpl db = new  DatabaseMethodsImpl();
		
		return db.deleteApplicant(app);
	}

	public void trainSkillsNN() {
		NNSkillModelImpl skillNN = new NNSkillModelImpl();
		skillNN.trainAndSaveModel();
	}



	public int deleteskill(Skills skill) {
		DatabaseMethodsImpl db = new  DatabaseMethodsImpl();
		return db.deleteskill(skill);
	}

	public int deleteExp(Experience exp) {
		DatabaseMethodsImpl db = new  DatabaseMethodsImpl();
		return db.deleteExp(exp);
	}

	public int deleteQualifications(Qualifications qualifications) {
		DatabaseMethodsImpl db = new  DatabaseMethodsImpl();
		return db.deleteQualifications(qualifications);
	}

	public ArrayList<Skills> getSkillInfo(Skills skill) {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet skillrs =db.getSkills(skill);
		ArrayList<Skills> skillArray = new ArrayList<Skills>();
		try {
			while(skillrs.next()){
				Skills sk = new Skills();
				sk.setSkill(skillrs.getString("name"));
				String eli = skillrs.getString("seligibility");
				boolean x = false;
				if(eli.equals("1")){
					x= true;
				}
				sk.setSeligibility(x);
				sk.setSkillID(skillrs.getInt("sid"));
				skillArray.add(sk);
			}
		} catch (SQLException e) {
			log.debug("Get skills failed : ", e);
		}
		return skillArray;
	}

	public ArrayList<Experience> getExpInfo(Experience exp) {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet exprs =db.getExp(exp);
		ArrayList<Experience> expArray = new ArrayList<Experience>();
		try {
			while(exprs.next()){
				Experience ex = new Experience();
				ex.setOrganization(exprs.getString("organization"));
				ex.setPost(exprs.getString("post"));
				String eli = exprs.getString("exeligibility");
				boolean x = false;
				if(eli.equals("1")){
					x= true;
				}
				ex.setExeligibility(x);
				ex.setExpid(exprs.getInt("exid"));
				ex.setDuration(exprs.getInt("duration"));
				expArray.add(ex);
			}
		} catch (SQLException e) {
			log.debug("Get experience failed : ", e);
		}
		return expArray;
	}

	public ArrayList<Qualifications> getQualificationsInfo(Qualifications qualification) {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet quars =db.getQualifications(qualification);
		ArrayList<Qualifications> quaArray = new ArrayList<Qualifications>();
		try {
			while(quars.next()){
				Qualifications ex = new Qualifications();
				ex.setId(quars.getInt("eid"));
				ex.setInstitute(quars.getString("institute"));
				ex.setName(quars.getString("name"));
				ex.setqClass(quars.getString("class"));
				String eli = quars.getString("eeligibility");
				boolean x = false;
				if(eli.equals("1")){
					x= true;
				}
				ex.setQualificationsEligibility(x);
				
				quaArray.add(ex);
			}
		} catch (SQLException e) {
			log.debug("Get qualifcations failed : ", e);
		}
		return quaArray;
	}

	public int addJob(Job job) {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		
		return db.addJob(job);
	}

	public ArrayList<Skills> getApplicantSkills(Applicants app) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Experience> getApplicantExp(Applicants app) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Qualifications> getApplicantQualifications(Applicants app) {
		// TODO Auto-generated method stub
		return null;
	}

	public void trainQualificationsExperienceNN() {
		// TODO Auto-generated method stub
		
	}


	public int evaluateApplicant(Applicants app) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Job> getUserJobInfo(Applicants app) {
		// TODO Auto-generated method stub
		return null;
	}
	





}
