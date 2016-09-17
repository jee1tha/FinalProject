package databaseLayer;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;

import org.apache.log4j.Logger;

public class DatabaseMethodsImpl implements DatabaseMethods {

	private static final Logger log = Logger.getLogger(DatabaseMethodsImpl.class);

	public static void main(String[] args) {
		/*// //testing applicant
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
*/	}

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
					+ "'" + admin.getPassword() + "'," + "'" + admin.getEmpNo() + "'," + "'" +admin.getRole() +"')";

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
			if (app.getUsername() != null && app.getPassword() != null) {
				query = "Select * from  `ingrow`.`users` WHERE username ='" + app.getUsername() + "' AND role ='user' AND password ='"+app.getPassword()+"'";
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
				query = "Select * from  `ingrow`.`users` WHERE id ='" + admin.getAdminID() + "' AND role ='"+admin.getRole()+"' ";
			}
			if (admin.getUsername() != null) {
				query = "Select * from  `ingrow`.`users` WHERE username ='" + admin.getUsername()+ "' ";
			}
			if (admin.getUsername() != null && admin.getRole() != null) {
				query = "Select * from  `ingrow`.`users` WHERE username ='" + admin.getUsername()
						+ "' AND role ='"+admin.getRole()+"'";
			}
			if (admin.getUsername() != null && admin.getPassword() !=null) {
				query = "Select * from  `ingrow`.`users` WHERE username ='" + admin.getUsername()
						+ "'AND password='"+admin.getPassword()+"'";
			}
			if (admin.getUsername() != null && admin.getPassword() !=null && admin.getRole() != null) {
				query = "Select * from  `ingrow`.`users` WHERE username ='" + admin.getUsername()
						+ "' AND role ='"+admin.getRole()+"' AND password='"+admin.getPassword()+"'";
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
			if (job.getName() == null && job.getJobid() == 0) {
				query = "Select * from  `ingrow`.`job`  ";
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
				query = "Delete from users where id ='" + admin.getAdminID() + "' AND role='"+admin.getRole()+"'";
			}
			if (admin.getUsername() != null) {
				query = "Delete from users where username ='" + admin.getUsername() + "' AND role='"+admin.getRole()+"'";
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
			
			
			String query = "INSERT INTO `ingrow`.`experience`(`organization`,`post`,`exeligibility`,`duration`)VALUES('"+ exp.getOrganization() 
				+"','"+ exp.getPost() +"','"+ boo + "','"+exp.getDuration()+"')";

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
			if (skill.getSeligibility() == false && skill.getSkill() == null && skill.getSkillID() == 0 ) {
				query = "Select * from  `ingrow`.`skill` WHERE seligibility = '0' ";
			}
			if (skill.getSkillID() != 0) {
				query = "Select * from  `ingrow`.`skill` WHERE sid ='" + skill.getSkillID() + "'";
			}
			if (skill.getSkill() != null) {
				query = "Select * from  `ingrow`.`skill` WHERE name ='" + skill.getSkill() + "' ";
			}
			if (skill.getSeligibility() == true ) {
				query = "Select * from  `ingrow`.`skill` WHERE seligibility = '1' ";
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
			int l = 0 ;
			if (exp.getExeligibility() == true) {
				l=1;
			}
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
				query = "Select * from  `ingrow`.`experience` WHERE exeligibility = '"+ l+"' ";
			}
			if (exp.getPost() != null && exp.getOrganization() != null ) {
				query = "Select * from  `ingrow`.`experience` WHERE post = '"+ exp.getPost() 
						+"' AND organization = '"+exp.getOrganization()+"'";
			}
			if (exp.getPost()== null && exp.getOrganization() == null && exp.getExeligibility() == false) {
				query = "Select * from  `ingrow`.`experience` WHERE exeligibility = '"+ l+"' ";
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
		// Creating object to get the database connection method
		String query = "";
		

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
			if (qualification.getqClass() != null) {
				query = "Select * from  `ingrow`.`educationqualifications` WHERE class = '"+ qualification.getqClass() +"' ";
			}
			if (qualification.getQualificationsEligibility() == true) {
				query = "Select * from  `ingrow`.`educationqualifications` WHERE eeligibility = '1' ";
			}
			if (qualification.getInstitute() != null && qualification.getName() != null && qualification.getqClass() != null) {
				query = "Select * from  `ingrow`.`educationqualifications` WHERE institute = '"+ qualification.getInstitute()
						+"' AND name = '"+qualification.getName()+"' AND class ='"+qualification.getqClass()+"'";
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
	public int updateEvaluatedApplicant(Applicants app,Job job){
		int result = 0;
		
		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		
		try {

			String query = "UPDATE `ingrow`.`userjob` SET `eligibilityFinal` = '"+job.getFinalScore()+"',`skillScore` = '"+job.getSkillScore()+"',`expQuaScore` = '"+job.getExpQuaScore()+"'WHERE `id` = '"+app.getAppID()+"' AND `jid` = '"+job.getJobid()+"';";
			try {

				result = newDb.insert(query);

				log.debug("Update user job  query executed");

			} catch (Exception e) {

				log.debug("Update user job query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("Update user job failed : ", e);

		}
		return result;
	}
	public int updateSkills(Skills skill) {
		
		int result = 0;
		int eli = 0;
		DBHandler newDb = new DBHandler();
		// Creating object to get the database connection method
		String query = null;
		
		if(skill.getSeligibility() == true ){
			eli = 1;
		}
			if(skill.getSkill() != null){
				query = "UPDATE `ingrow`.`skill` SET `seligibility` = '"+ eli +"' WHERE `name` = '"+skill.getSkill()+"'";
			}
			if(skill.getSkillID() != 0){
				query = "UPDATE `ingrow`.`skill` SET `seligibility` = '"+ eli +"' WHERE `sid` = '"+skill.getSkillID()+"'";
			}
			
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

		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		
		try {

			String query = "INSERT INTO `ingrow`.`userexperience`(`id`,`exid`)VALUES('"+ app.getAppID()
							+"','"+ exp.getExpid() +"')";
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
		
		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		
		try {

			String query = "INSERT INTO `ingrow`.`userjob`(`id`,`jid`,`eligibilityFinal`,`skillScore`,`expQuaScore`)VALUES('"+app.getAppID()+"','"+job.getJobid()+"','"+job.getFinalScore()+"','"+job.getSkillScore()+"','"+job.getExpQuaScore()+"')";
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

	
	
	public boolean checkUsername(Users user) {
		boolean results = false;
		DBHandler newDb = new DBHandler();
		String query = "";
		// Creating object to get the database connection method

		try {
			if (user.getUsername() != null) {
				query = "Select * from  `ingrow`.`users` WHERE username ='" + user.getUsername() + "' ";
			}
			
			try {

				ResultSet result = newDb.getdata(query);
				if(result.next()){
					results = true;
				}
				log.debug("get Username query executed");

			} catch (Exception e) {

				log.debug("get Username query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("get Username failed : ", e);

		}

		return results;
	}
	
	public String login(Users user) {
		String results = null;
		DBHandler newDb = new DBHandler();
		String query = "";
		// Creating object to get the database connection method

		try {
			if (user.getUsername() != null && user.getPassword() != null ) {
				query = "Select * from  `ingrow`.`users` WHERE username ='" + user.getUsername() + "' AND password='"+ user.getPassword() +"' ";
			}
			
			try {

				ResultSet result = newDb.getdata(query);
				if(result.next()){
					
					results = result.getString("role");
				}else{
					results = "fail";
				}
				log.debug("Login query executed for"+ user.getUsername());

			} catch (Exception e) {

				log.debug("Login query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("get Username failed : ", e);

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
	public ResultSet checkUserJob(Applicants app,Job job) {



		ResultSet results = null;
		
		DBHandler newDb = new DBHandler();
		
		String query = "";
		// Creating object to get the database connection method

		try {
			if (app.getAppID() != 0) {
				query = "Select * from  `ingrow`.`userjob` WHERE id ='" + app.getAppID() + "' AND jid='"+job.getJobid()+ "'";
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
		ResultSet results = null;
		
		DBHandler newDb = new DBHandler();
		
		String query = "";
		// Creating object to get the database connection method

		try {
			if (app.getAppID() != 0) {
				query = "Select exid from  `ingrow`.`userexperience` WHERE id ='" + app.getAppID() + "'";
			}
			
		
			try {

				results = newDb.getdata(query);

				log.debug("get user exp query executed");

			} catch (Exception e) {

				log.debug("get get user exp query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("get user exp failed : ", e);

		}

		return results;
	}

	public int deleteskill(Skills skill) {
		int result = 0;

		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		String query = "";
		try {
			if (skill.getSkillID() != 0) {
				query = "Delete from skill where sid ='" + skill.getSkillID() + "' ";
			}
			if (skill.getSkill() != null) {
				query = "Delete from skill where name ='" + skill.getSkill() + "' ";
			}

			try {

				result = newDb.insert(query);

				log.debug("delete skill  query executed");

			} catch (Exception e) {

				log.debug("delete skill  query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("delete skill failed : ", e);

		}
		return result;
	}

	public int deleteExp(Experience exp) {
		int result = 0;

		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		String query = "";
		try {
			if (exp.getExpid() != 0) {
				query = "Delete from experience where exid ='" + exp.getExpid() + "' ";
			}
			if (exp.getOrganization() != null && exp.getPost() != null && exp.getDuration() != 0) {
				query = "Delete from experience where organization ='" + exp.getOrganization()+ "' AND duration ='"+exp.getDuration()+"' AND post ='"+exp.getPost()+"' ";
			}

			try {

				result = newDb.insert(query);

				log.debug("delete skill  query executed");

			} catch (Exception e) {

				log.debug("delete skill  query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("delete skill failed : ", e);
	}
		return result;
	}
	public int deleteQualifications(Qualifications qualifications) {
		int result = 0;

		DBHandler newDb = new DBHandler();

		// Creating object to get the database connection method
		String query = "";
		try {
			if (qualifications.getId() != 0) {
				query = "Delete from educationqualifications where eid ='" + qualifications.getId() + "' ";
			}
			if (qualifications.getClass() != null && qualifications.getInstitute() != null && qualifications.getName() != null) {
				query = "Delete from educationqualifications where institute ='" + qualifications.getInstitute() + "' AND name ='"+qualifications.getName()+"' AND class ='"+qualifications.getqClass()+"' ";
			}

			try {

				result = newDb.insert(query);

				log.debug("delete skill  query executed");

			} catch (Exception e) {

				log.debug("delete skill  query failed : ", e);
			}

		} catch (Exception e) {

			log.debug("delete skill failed : ", e);
	}
		return result;
	}

	public ResultSet getUserEvaluationAll() {
		ResultSet results = null;
		
		DBHandler newDb = new DBHandler();
		
			String query = "SELECT * FROM ingrow.userjob order by eligibilityFinal DESC";
			
			try {

				results = newDb.getdata(query);

				log.debug("get all user evaluations ordered by Descending order executed");

			} catch (Exception e) {

				log.debug("get all user evaluations ordered by Descending order query failed : ", e);
			}

		return results;
	}

	public ResultSet getSkillAll() {

		ResultSet results = null;
		
		DBHandler newDb = new DBHandler();
		
		String query = "";
	

		try {
		
				query = "Select * from  `ingrow`.`skill` ";
				results = newDb.getdata(query);

				log.debug("get All skills query executed");


		} catch (Exception e) {

			log.debug("get All skills failed : ", e);

		}

		return results;
	}

	public ResultSet getExpAll() {
	ResultSet results = null;
		
		DBHandler newDb = new DBHandler();
		
		String query = "";
	

		try {
		
				query = "Select * from  `ingrow`.`experience` ";
				results = newDb.getdata(query);

				log.debug("get All experience query executed");


		} catch (Exception e) {

			log.debug("get All experience failed : ", e);

		}

		return results;
	}

	public ResultSet getQualificationsAll() {
	ResultSet results = null;
		
		DBHandler newDb = new DBHandler();
		
		String query = "";
	

		try {
		
				query = "Select * from  `ingrow`.`educationqualifications` ";
				results = newDb.getdata(query);

				log.debug("get All education qualifications query executed");


		} catch (Exception e) {

			log.debug("get All education qualifications failed : ", e);

		}

		return results;
	}




}
