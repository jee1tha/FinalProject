package databaseLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class DatabaseMethodsImpl implements DatabaseMethods {

	private static final Logger log = Logger.getLogger(DatabaseMethodsImpl.class);

	public static void main(String[] args) {
		// //testing applicant
		Applicants app = new Applicants();
		app.setName("testingconnection");
		app.setBirthDate("2010-05-30");
		app.setContactNo("0881231231");
		app.setEmail("asdasd@Aasd.com");
		app.setNicNo("0010101010v");
		app.setUsername("TestingConnection2");
		// app.setPassword("testingConnectionPassword");
		// app.setEmpNo("001");
		// app.setAppID(3);
		//
		Skills sk = new Skills();
		sk.setSkill("skill1");
		sk.setSeligibility(true);
		Job j = new Job();
		j.setName("testjob1");
		j.setJobDescription("description of the job goes here");
		DatabaseMethodsImpl b = new DatabaseMethodsImpl();
	//	ResultSet rs = b.getJobDetails(j);
//		try {
//			while (rs.next()) {
//				System.out.println(rs.getString("description"));
//
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Experience exp = new Experience();
		exp.setPost("intern");
		exp.setOrganization("pearson");
		exp.setExeligibility(true);
		
		
		Qualifications qua = new Qualifications();
		qua.setInstitute("Sliit");
		qua.setName("Higher National Diploma");
		qua.setQualificationsEligibility(true);
		
		System.out.println(b.addQualifications(qua));
		// // testing skills
		// Skills ski = new Skills();
		//
		// ArrayList<String> n = new ArrayList<String>();
		// n.add("skill1");
		// n.add("skill2");
		// ski.setSkillName(n);
		// DatabaseMethodsImpl b = new DatabaseMethodsImpl();
		// System.out.println( b.addSkills(app, ski));
		// try{
		// System.out.println(b.getSkillDetails(app).get(0).getSkill());
		// }catch (Exception a){
		// log.debug("top level failure : ", a);
		// }
		// System.out.println(b.getSkillDetails(app).get(1).getSkill());
		// //testing admin
		// Admin n = new Admin();
		// n.setName("testingconnection");
		//
		// n.setContactNo("0881231231");
		// n.setEmail("asdasd@Aasd.com");
		//

		// n.setUsername("UNITTESTING");
		// n.setPassword("testingConnectionPassword");
		// n.setJoinedDate("22/22/2220");
		// n.setEmpNo("01");
		//

		// System.out.println( b.getAdminDetails(n).get(0).getContactNo());
	}

	public int addApplicant(Applicants app) {
		int result = 0;
		DBHandler newDb = new DBHandler();
		// Creating object to get the database connection method

		try {
			String query = "INSERT INTO `ingrow`.`users`(" + "`name`,`" + "birthday`,`" + "contactNo`,`" + "email`,`"
					+ "username`,`" + "password`,`" + "nicno`,`" + "role`)" + "VALUES (   '" + app.getName() + "',"
					+ "'" + app.getBirthDate() + "'," + "'" + app.getContactNo() + "'," + "'" + app.getEmail() + "',"
					+ "'" + app.getUsername() + "'," + "'" + app.getPassword() + "'," + "'" + app.getNicNo() + "',"
					+ "'user')";

			try {

				result = newDb.insert(query);

				log.debug("insert query executed");

			} catch (Exception e) {

				log.debug("add applicant query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("add applicant failed : ", e);

		}

		return result;
	}

	public int addAdmin(Admin admin) {

		int result = 0;

		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method

		try {

			String query = "INSERT INTO `ingrow`.`users`(" + "`name`,`" + "contactno`,`" + "email`,`" + "username`,`"
					+ "password`,`" + "empno`,`" + "role`)" + "VALUES (   '" + admin.getName() + "'," + "'"
					+ admin.getContactNo() + "'," + "'" + admin.getEmail() + "'," + "'" + admin.getUsername() + "',"
					+ "'" + admin.getPassword() + "'," + "'" + admin.getEmpNo() + "'," + "'admin')";

			try {

				result = newDb.insert(query);

				log.debug("insert admin query executed");

			} catch (Exception e) {

				log.debug("add admin query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("add admin failed : ", e);

		}
		return result;
	}

	public int addSuperAdmin(Admin admin) {

		int result = 0;

		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method

		try {

			String query = "INSERT INTO `ingrow`.`users`(" + "`name`,`" + "contactno`,`" + "email`,`" + "username`,`"
					+ "password`,`" + "empno`,`" + "role`)" + "VALUES (   '" + admin.getName() + "'," + "'"
					+ admin.getContactNo() + "'," + "'" + admin.getEmail() + "'," + "'" + admin.getUsername() + "',"
					+ "'" + admin.getPassword() + "'," + "'" + admin.getEmpNo() + "'," + "'super')";

			try {

				result = newDb.insert(query);

				log.debug("insert admin query executed");

			} catch (Exception e) {

				log.debug("add admin query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("add admin failed : ", e);

		}
		return result;
	}

	public int addJob(Job job) {
		int result = 0;

		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method

		try {

			String query = "INSERT INTO `ingrow`.`job`(`name`,`description`)VALUES ( '" + job.getName() + "','"
					+ job.getJobDescription() + "')";

			try {

				result = newDb.insert(query);

				log.debug("insert job query executed");

			} catch (Exception e) {

				log.debug("add job query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("add job failed : ", e);

		}
		return result;
	}

	public ResultSet getApplicantDetails(Applicants app) {

		ResultSet results = null;
		DBHandler newDb = new DBHandler();
		String query = "";
		// Creating object to get the database connection method

		try {
			if (app.getAppID() != 0) {
				query = "Select * from  `ingrow`.`users` WHERE id ='" + app.getAppID() + "' AND role ='user' ";
			}
			if (app.getUsername() != null) {
				query = "Select * from  `ingrow`.`users` WHERE username ='" + app.getUsername() + "' AND role ='user'";
			}
			try {

				results = newDb.getdata(query);

				log.debug("get users query executed");

			} catch (Exception e) {

				log.debug("get users query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("get users failed : ", e);

		}

		return results;
	}

	public ResultSet getAdminDetails(Admin admin) {

		ResultSet results = null;
		DBHandler newDb = new DBHandler();
		String query = "";
		// Creating object to get the database connection method

		try {
			if (admin.getAdminID() != 0) {
				query = "Select * from  `ingrow`.`users` WHERE id ='" + admin.getAdminID() + "' AND role ='admin' ";
			}
			if (admin.getUsername() != null) {
				query = "Select * from  `ingrow`.`users` WHERE username ='" + admin.getUsername()
						+ "' AND role ='admin'";
			}
			try {

				results = newDb.getdata(query);

				log.debug("get admin details query executed");

			} catch (Exception e) {

				log.debug("get admin details query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("get admin details failed : ", e);

		}

		return results;

	}

	public ResultSet getJobDetails(Job job) {

		ResultSet results = null;
		DBHandler newDb = new DBHandler();
		String query = "";
		// Creating object to get the database connection method

		try {
			if (job.getJobid() != 0) {
				query = "Select * from  `ingrow`.`job` WHERE jid ='" + job.getJobid() + "'";
			}
			if (job.getName() != null) {
				query = "Select * from  `ingrow`.`job` WHERE name ='" + job.getName() + "' ";
			}
			try {

				results = newDb.getdata(query);

				log.debug("get job query executed");

			} catch (Exception e) {

				log.debug("get job query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("get job failed : ", e);

		}

		return results;

	}

	public int deleteApplicant(Applicants app) {

		int result = 0;

		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		String query = "";
		try {
			if (app.getAppID() != 0) {
				query = "Delete from users where id ='" + app.getAppID() + "' AND role='user'";
			}
			if (app.getUsername() != null) {
				query = "Delete from users where username ='" + app.getUsername() + "' AND role='user'";
			}

			try {

				result = newDb.insert(query);

				log.debug("delete applicant  query executed");

			} catch (Exception e) {

				log.debug("delete applicant  query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("delete applciant failed : ", e);

		}
		return result;
	}

	public int deleteAdmin(Admin admin) {

		int result = 0;

		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		String query = "";
		try {
			if (admin.getAdminID() != 0) {
				query = "Delete from users where id ='" + admin.getAdminID() + "' AND role='admin'";
			}
			if (admin.getUsername() != null) {
				query = "Delete from users where username ='" + admin.getUsername() + "' AND role='admin'";
			}

			try {

				result = newDb.insert(query);

				log.debug("delete Admin  query executed");

			} catch (Exception e) {

				log.debug("delete Admin  query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("delete Admin failed : ", e);

		}
		return result;
	}

	public int deleteSuperAdmin(Admin admin) {
		
		int result = 0;

		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		String query = "";
		try {
			if (admin.getAdminID() != 0) {
				query = "Delete from users where id ='" + admin.getAdminID() + "' AND role='super'";
			}
			if (admin.getUsername() != null) {
				query = "Delete from users where username ='" + admin.getUsername() + "' AND role='super'";
			}

			try {

				result = newDb.insert(query);

				log.debug("delete Super Admin   query executed");

			} catch (Exception e) {

				log.debug("delete Super Admin  query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("delete Super Admin  failed : ", e);

		}
		return result;
	}

	public int deleteJob(Job job) {

		int result = 0;

		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		String query = "";
			try {
			 if(job.getJobid() !=0){
				query = "Delete from job where jid ='" + job.getJobid() + "'";
			 }
			 if(job.getName() != null){
				 query = "Delete from job where name = '"+ job.getName() + "'";
			 }
			try {

				result = newDb.insert(query);

				log.debug("delete job   query executed");

			} catch (Exception e) {

				log.debug("delete job  query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("delete job  failed : ", e);

		}
		return result;
		
	}

	public int addSkills(Skills skill) {
		int result = 0;

		DBHandler newDb = new DBHandler();
		
		int boo = 0;
		
		if(skill.getSeligibility() == true){
			boo = 1;
		}
		// Creating object to get the database connection method

		try {
			
			
			String query = "INSERT INTO `ingrow`.`skill`(`name`,`seligibility`)VALUES('"+ skill.getSkill() 
				+"','"+ boo +"'	)";

			try {

				result = newDb.insert(query);

				log.debug("insert skills query executed");

			} catch (Exception e) {

				log.debug("add skills query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("add skills failed : ", e);

		}
		return result;
	}

	public int addExp(Experience exp) {
		
		int result = 0;
		
		int boo = 0;
		
		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		
		if(exp.getExeligibility() == true){
			boo = 1;
		}
		
		try {
			
			
			String query = "INSERT INTO `ingrow`.`experience`(`organization`,`post`,`exeligibility`)VALUES('"+ exp.getOrganization() 
				+"','"+ exp.getPost() +"','"+ boo + "')";

			try {

				result = newDb.insert(query);

				log.debug("insert experience query executed");

			} catch (Exception e) {

				log.debug("add experience query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("add experience failed : ", e);

		}
		return result;
	}

	public int addQualifications(Qualifications qualification) {
		
		int result = 0;
		
		int boo = 0;
		
		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		
		if(qualification.getQualificationsEligibility() == true){
			boo = 1;
		}
		
		try {
			
			
			String query = "INSERT INTO `ingrow`.`educationqualifications`(`institute`,`name`,`class`,`eeligibility`)VALUES('"+ qualification.getInstitute() 
				+"','"+ qualification.getName() +"','"+qualification.getqClass()+"','"+ boo + "')";

			try {

				result = newDb.insert(query);

				log.debug("insert qualification query executed");

			} catch (Exception e) {

				log.debug("add qualification query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("add qualification failed : ", e);

		}
		return result;
	}

	public ResultSet getSkills(Skills skill) {

		ResultSet results = null;
		
		DBHandler newDb = new DBHandler();
		
		String query = "";
		// Creating object to get the database connection method

		try {
			if (skill.getSkillID() != 0) {
				query = "Select * from  `ingrow`.`skill` WHERE sid ='" + skill.getSkillID() + "'";
			}
			if (skill.getSkill() != null) {
				query = "Select * from  `ingrow`.`skill` WHERE name ='" + skill.getSkill() + "' ";
			}
			if (skill.getSeligibility() == true ) {
				query = "Select * from  `ingrow`.`skill` WHERE seligibility = '1' ";
			}
			if (skill.getSeligibility() == false ) {
				query = "Select * from  `ingrow`.`skill` WHERE seligibility = '0' ";
			}
			
			try {

				results = newDb.getdata(query);

				log.debug("get skill query executed");

			} catch (Exception e) {

				log.debug("get skill query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("get skill failed : ", e);

		}

		return results;

	}

	public ResultSet getExp(Experience exp) {
	ResultSet results = null;
		
		DBHandler newDb = new DBHandler();
		
		String query = "";
		// Creating object to get the database connection method

		try {
			if (exp.getExpid() != 0) {
				query = "Select * from  `ingrow`.`experience` WHERE exid ='" + exp.getExpid() + "'";
			}
			if (exp.getOrganization() != null) {
				query = "Select * from  `ingrow`.`experience` WHERE organization ='" + exp.getOrganization() + "' ";
			}
			if (exp.getPost() != null) {
				query = "Select * from  `ingrow`.`experience` WHERE post = '"+exp.getPost()+"' ";
			}
			if (exp.getExeligibility() == true) {
				query = "Select * from  `ingrow`.`experience` WHERE exeligibility = '"+ exp.getExeligibility() +"' ";
			}
			if (exp.getPost() != null && exp.getOrganization() != null ) {
				query = "Select * from  `ingrow`.`experience` WHERE post = '"+ exp.getPost() 
						+"' AND organization = '"+exp.getOrganization()+"'";
			}
			
		
			try {

				results = newDb.getdata(query);

				log.debug("get skill query executed");

			} catch (Exception e) {

				log.debug("get skill query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("get skill failed : ", e);

		}

		return results;
	}

	public ResultSet getQualifications(Qualifications qualification) {
		
		ResultSet results = null;
		
		DBHandler newDb = new DBHandler();
		
		String query = "";
		// Creating object to get the database connection method

		try {
			if (qualification.getId() != 0) {
				query = "Select * from  `ingrow`.`educationqualifications` WHERE eid ='" + qualification.getId()  + "'";
			}
			if (qualification.getInstitute() != null) {
				query = "Select * from  `ingrow`.`educationqualifications` WHERE institute ='" + qualification.getInstitute() + "' ";
			}
			if (qualification.getName() != null) {
				query = "Select * from  `ingrow`.`educationqualifications` WHERE name = '"+ qualification.getName() +"' ";
			}
			if (qualification.getQualificationsEligibility() == true) {
				query = "Select * from  `ingrow`.`educationqualifications` WHERE eeligibility = '1' ";
			}
			if (qualification.getInstitute() != null && qualification.getName() != null ) {
				query = "Select * from  `ingrow`.`educationqualifications` WHERE institute = '"+ qualification.getInstitute()
						+"' AND name = '"+qualification.getName()+"'";
			}
			if (qualification.getQualificationsEligibility() == false && qualification.getInstitute() == null && qualification.getId() == 0 && qualification.getName() == null) {
				query = "Select * from  `ingrow`.`educationqualifications` WHERE eeligibility = '0' ";
			}
			
		
			try {

				results = newDb.getdata(query);

				log.debug("get qualification query executed");

			} catch (Exception e) {

				log.debug("get qualification query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("get qualification failed : ", e);

		}

		return results;
	}

	public int updateSkills(Skills skill) {
		
		int result = 0;
		int eli = 0;
		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		if(skill.getSeligibility() == true ){
			eli = 1;
		}
		
			String query = "UPDATE `ingrow`.`skill` SET `seligibility` = '"+ eli +"' WHERE `sid` = '"+skill.getSkillID()+"'";
			try {

				result = newDb.insert(query);

				log.debug("Update skill eligibility query executed");

			} catch (Exception e) {

				log.debug("Update skill eligibility query failed : ", e);
			}
		
		
		
		return result;
	}

	public int updateExp(Experience exp) {
		
		int result = 0;
		int eli = 0;
		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		if(exp.getExeligibility() == true ){
			eli = 1;
		}
		
			String query = "UPDATE `ingrow`.`experience` SET `exeligibility` = '"+ eli +"' WHERE `exid` = '"+ exp.getExpid()+"'";
			try {

				result = newDb.insert(query);

				log.debug("Update experience eligibility query executed");

			} catch (Exception e) {

				log.debug("Update experience eligibility query failed : ", e);
			}
		
		
		
		return result;
	}

	public int updateQualifications(Qualifications qualifications) {

		int result = 0;
		int eli = 0;
		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		if(qualifications.getQualificationsEligibility() == true ){
			eli = 1;
		}
		
			String query = "UPDATE `ingrow`.`educationqualifications` SET `eeligibility` = '"+ eli +"' WHERE `eid` = '"+ qualifications.getId()+"'";
			try {

				result = newDb.insert(query);

				log.debug("Update qualifications eligibility query executed");

			} catch (Exception e) {

				log.debug("Update qualifications eligibility query failed : ", e);
			}
		
		
		
		return result;
	}

	public int addApplicantSkills(Applicants app, Skills skill) {
		int result = 0;

		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method

		try {

			String query = "INSERT INTO `ingrow`.`skillsuser` (`id`,`sid`) VALUES ('"+app.getAppID()+"','"+
							skill.getSkillID()+"')";
			try {

				result = newDb.insert(query);

				log.debug("insert user skills  query executed");

			} catch (Exception e) {

				log.debug("add user skills query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("add user skills failed : ", e);

		}
		return result;
	}

	public int addApplicantExp(Applicants app, Experience exp) {
		int result = 0;
		int eli =0;
		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		if(exp.getUeeligibility() == true){
			eli = 1;
		}
		try {

			String query = "INSERT INTO `ingrow`.`userexperience`(`id`,`exid`,`duration`,`ueeligibility`)VALUES('"+ app.getAppID()
							+"','"+ exp.getExpid() +"','"+ exp.getDuration() +"','"+eli+"')";
			try {

				result = newDb.insert(query);

				log.debug("insert user experience  query executed");

			} catch (Exception e) {

				log.debug("add user experience query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("add user experience failed : ", e);

		}
		return result;
	}

	public int addApplicantQualifcations(Applicants app, Qualifications qualification) {
		int result = 0;
		
		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		
		try {

			String query = "INSERT INTO `ingrow`.`usereducationalqualifications`(`id`,	`eid`)	VALUES	('"+app.getAppID()
							+"','"+ qualification.getId() +"')";
			try {

				result = newDb.insert(query);

				log.debug("insert user qualification  query executed");

			} catch (Exception e) {

				log.debug("add user qualification query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("add user qualification failed : ", e);

		}
		return result;
		
		
	}

	public int addApplicantJob(Applicants app,Job job){
		int result = 0;
		double eli = 0;
		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		if(job.geteligibility() != 0){
			eli = job.geteligibility() ;
		}
		try {

			String query = "INSERT INTO `ingrow`.`userjob`(`id`,`jid`,`eligibility`)VALUES('"+app.getAppID()+"','"+job.getJobid()+"','"+eli+"')";
			try {

				result = newDb.insert(query);

				log.debug("insert user job  query executed");

			} catch (Exception e) {

				log.debug("add user job query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("add user job failed : ", e);

		}
		return result;
	}

	public boolean checkApplicantUsername(Applicants app) {

		boolean results = false;
		DBHandler newDb = new DBHandler();
		String query = "";
		// Creating object to get the database connection method

		try {
			if (app.getUsername() != null) {
				query = "Select * from  `ingrow`.`users` WHERE username ='" + app.getUsername() + "' ";
			}
			
			try {

				ResultSet result = newDb.getdata(query);
				if(result.next()){
					results = true;
				}
				log.debug("get users query executed");

			} catch (Exception e) {

				log.debug("get users query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("get users failed : ", e);

		}

		return results;
	}

	public ResultSet getUserJobStatus(Applicants app) {



		ResultSet results = null;
		
		DBHandler newDb = new DBHandler();
		
		String query = "";
		// Creating object to get the database connection method

		try {
			if (app.getAppID() != 0) {
				query = "Select * from  `ingrow`.`userjob` WHERE id ='" + app.getAppID() + "'";
			}
			
		
			try {

				results = newDb.getdata(query);

				log.debug("get userjob query executed");

			} catch (Exception e) {

				log.debug("get userjob query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("get userjob failed : ", e);

		}

		return results;
	}

	public ResultSet getApplicantQualifications(Applicants app) {

		ResultSet results = null;
		
		DBHandler newDb = new DBHandler();
		
		String query = "";
		// Creating object to get the database connection method

		try {
			if (app.getAppID() != 0) {
				query = "Select eid from  `ingrow`.`usereducationalqualifications` WHERE id ='" + app.getAppID() + "'";
			}
			
		
			try {

				results = newDb.getdata(query);

				log.debug("get user qualifications query executed");

			} catch (Exception e) {

				log.debug("get user qualifications query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("get user qualifications failed : ", e);

		}

		return results;
	}

	public ResultSet getApplicantSkills(Applicants app) {

		ResultSet results = null;
		
		DBHandler newDb = new DBHandler();
		
		String query = "";
		// Creating object to get the database connection method

		try {
			if (app.getAppID() != 0) {
				query = "Select sid from  `ingrow`.`skillsuser` WHERE id ='" + app.getAppID() + "'";
			}
			
		
			try {

				results = newDb.getdata(query);

				log.debug("get userskills query executed");

			} catch (Exception e) {

				log.debug("get userskills query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("get userskills failed : ", e);

		}

		return results;
	}

	public ResultSet getApplicantExperience(Applicants app) {
		// TODO Auto-generated method stub
		return null;
	}



}
