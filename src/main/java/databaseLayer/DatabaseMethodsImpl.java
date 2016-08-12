package databaseLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class DatabaseMethodsImpl implements DatabaseMethods{
	
	private static final Logger log = Logger.getLogger(log4jtest.class);
	 
	public static void main(String[] args){
//		//testing applicant
		Applicants app= new Applicants();
//		app.setName("testingconnection");
//		app.setBirthDate("09/02/2291");
//		app.setContactNo("0881231231");
//		app.setEmail("asdasd@Aasd.com");
//		app.setNicNo("0010101010v");
	//	app.setUsername("TestingConnection");
//		app.setPassword("testingConnectionPassword");
	//	app.setAppID(1);
//
//		// testing skills
//		Skills ski = new Skills();
//		
//		ArrayList<String> n = new ArrayList<String>();
//		n.add("skill1");
//		n.add("skill2");
//		ski.setSkillName(n);
		DatabaseMethodsImpl b = new DatabaseMethodsImpl();
////		System.out.println(	b.addSkills(app, ski));
		System.out.println(b.getSkillDetails(app).get(0).getSkill());
		System.out.println(b.getSkillDetails(app).get(1).getSkill());
////		//testing admin
//		Admin n = new Admin();
//		 n.setName("testingconnection");
//		
//		 n.setContactNo("0881231231");
//		 n.setEmail("asdasd@Aasd.com");
//		
//		 n.setUsername("TestingConnection");
//		 n.setPassword("testingConnectionPassword");
//		 n.setJoinedDate("22/22/2220");
//		 n.setEmpNo("01");
//		
//		DatabaseMethodsImpl b = new DatabaseMethodsImpl();
//		System.out.println(	b.getAdminDetails(n).get(0).getContactNo());
	}
	
	public int addApplicant(Applicants app){
		
		
		int result = 0;
		DBHandler newDB = new DBHandler(); // Creating object to get the database connection method
		
		try {
			 String query = "INSERT INTO `ingrow`.`applicant`("
			 		+ "`name`,`"
			 		+ "birthDate`,`"
			 		+ "contactNo`,`"
			 		+ "email`,`"
			 		+ "username`,`"
			 		+ "password`)"
			 		+ "VALUES ('" 	+ app.getName() + "',"
			 						+ "'" + app.getBirthDate() + "',"
			 						+ "'"+ app.getContactNo() +"',"
			 						+ "'"+ app.getEmail() +"',"
									+ "'"+ app.getUsername() +"',"
									+ "'" +app.getPassword() + "')";

	          
			try {
                result = newDB.insert(query);
            } catch (Exception e) {
            	log.debug("add applicant query failed : ", e);
            }
			
		}catch (Exception e){
			log.debug("add applicant failed : ", e);
		}
		 return result;
	}
	
	public int addAdmin(Admin admin){
		
		int result = 0;
		
		DBHandler newDB = new DBHandler(); // Creating object to get the database connection method
		
		try {
			 String query = "INSERT INTO `ingrow`.`admin`("
			 		+ "`name`,`"
			 		+ "email`,`"
			 		+ "contactNumber`,`"
			 		+ "username`,`"
			 		+ "password`,`"
			 		+ "empNo`,`"
			 		+ "joinedDate`)"
			 		+ "VALUES ('" 	+ admin.getName() + "',"
			 						+ "'" + admin.getEmail() + "',"
			 						+ "'"+ admin.getContactNo() +"',"
			 						+ "'"+ admin.getUsername() +"',"
									+ "'"+ admin.getPassword()+"',"
									+ "'"+ admin.getEmpNo() +"',"
									+ "'" +admin.getJoinedDate()+ "')";

	          
			try {
				
                result = newDB.insert(query);
                
            } catch (Exception e) {
            	
            	log.debug("insert admin query failed : ", e);
            	
            }
			
		}catch (Exception e){
			log.debug("add admin failed : ", e);		}
		
		return result;
	}
	
	public int addSkills(Applicants app, Skills skill){
		
		int result =0;
		
		for (int i = 0; i < skill.getSkillName().size(); i++){
			String query = "INSERT INTO skills (`sName`,`applicantID`)VALUES('"+ skill.getSkillName().get(i) +"','"+ app.getAppID() +"');" ;
			DBHandler newDB = new DBHandler();
			
			try{ 
				result = newDB.insert(query);
			} catch (Exception ex){
				log.debug("add skills failed : ", ex);
			}
		}
		
		return result;
	}
	
	public boolean checkApplicantUsername(Applicants app){
		
		String query = "Select * from applicant where username ='"+app.getUsername()+"'";
		boolean result = false;
		DBHandler newDB = new DBHandler();
		String username = null;
		String check =	app.getUsername() ;
		ResultSet res = newDB.getdata(query);
		try {
			while (res.next()) {
				username =res.getString("username");
		  }
		
		
			
		} catch (Exception e1) {
			log.debug("getting applicant username from db failed: ", e1);
				}
		try{
			if(username.equals(check)){
			
				result = true;
			}
	
	}catch (Exception e){
		log.debug("check Applicant username failed : ", e);
	}
		return result;
	}
	
	public ArrayList<Applicants> getApplicantDetails(Applicants app){
		String query = null;
		 ArrayList<Applicants> appArray = new ArrayList<Applicants>();
		if(app.getUsername() != null){
			query = "Select * from applicant where username = '"+ app.getUsername() + "'";
			}
	    DBHandler con = new DBHandler();
	    
	    try{
        ResultSet res = con.getdata(query);
              
        while (res.next()){
        	Applicants a = new Applicants();
        	a.setAppID(res.getInt("aId"));
        	a.setName(res.getString("name"));
        	a.setBirthDate(res.getString("birthDate"));
        	a.setContactNo(res.getString("contactNo"));
        	a.setNicNo(res.getString("nicNo"));
        	a.setEmail(res.getString("email"));
        	
        	appArray.add(a);
        }
	}catch (Exception e){
		log.debug("get applicant details failed : ", e);
	}
	    
	    return appArray;
	}

	public ArrayList<Admin> getAdminDetails(Admin admin){
		String query = null;
		
		ArrayList<Admin> adminArray = new ArrayList<Admin>();
		
		if(admin.getUsername() != null){
			query = "Select * from admin where username = '"+ admin.getUsername() + "'";
			}
	    DBHandler con = new DBHandler();
	    
	    try{
        ResultSet res = con.getdata(query);
              
        while (res.next()){
        	Admin a = new Admin();
        	a.setAdminID(res.getInt("adminId"));
        	a.setName(res.getString("name"));
        	a.setContactNo(res.getString("contactNumber"));
        	a.setEmail(res.getString("email"));
        	a.setEmpNo(res.getString("empNo"));
        	a.setJoinedDate(res.getString("joinedDate"));
        	adminArray.add(a);
        }
	}catch (Exception e){
		log.debug("get admin details failed : ", e);
	}
	    
	    return adminArray;
	}

	public ArrayList<Skills> getSkillDetails(Applicants app){
			String query = null;
		
		ArrayList<Skills> skillsArray = new ArrayList<Skills>();
		
		if(app.getAppID() != 0){
			query = "Select * from skills where applicantID = '"+ app.getAppID()+ "'";
		}
	    DBHandler con = new DBHandler();
	    
	    try{
        ResultSet res = con.getdata(query);
              
        while (res.next()){
        	Skills a = new Skills();
        	a.setSkillID(res.getInt("skillID"));
        	a.setSkill(res.getString("sName"));
        	skillsArray.add(a);
        }
	}catch (Exception e){
		log.debug("get skills failed : ", e);
	}
	    
	    return skillsArray;
	}
}
