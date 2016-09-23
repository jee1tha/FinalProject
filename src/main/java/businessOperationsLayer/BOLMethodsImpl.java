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
import databaseLayer.Users;

public class BOLMethodsImpl implements BOLMethods{
	
	private static final Logger log = Logger.getLogger(BOLMethodsImpl.class);
	private static boolean flagQE = true;
	private static boolean flagS= true;
	public int RegisterUser(Applicants app) {
		int result = 0;
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		if(db.checkUsername(app) == false){
			result = db.addApplicant(app);
		}
		
		return result;
	}

	public int RegisterAdmin(Admin admin) {
		int result = 0;
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		if(db.checkUsername(admin)==false){
			result = db.addAdmin(admin); 
		}
		return result;
	}

	public String LoginUser(Users user) {
		String result = null;
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		String rs = db.login(user);
		
		return rs;
	}


	public int addSkills(Skills skill) {
		int result = 0;
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet rs = db.getSkills(skill);
		
		try {
			boolean z = rs.next() ;
			if(z==false){
				result = db.addSkills(skill);
				log.debug("New Skill Added" );
			}
			log.debug("Skills already exists" );
			
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
			}else{
                            log.debug("New Experience aleady exists" );
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
				log.debug("New Qualification Added" );
			}else{
                            log.debug("New Qualification already exists" );
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
			log.debug("Get applicants  ");
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
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet uSkills =db.getApplicantSkills(app);
		ArrayList<Skills> skillArray = new ArrayList<Skills>();
		try {
			while(uSkills.next()){
				Skills sk = new Skills();
				sk.setSkillID(uSkills.getInt("sid"));
				
				DatabaseMethodsImpl db2 = new DatabaseMethodsImpl();
				ResultSet skill = db2.getSkills(sk);
				
					while(skill.next()){
						boolean eligi = false;
						Skills sk2= new Skills();
						sk2.setSkill(skill.getString("name"));
						if(skill.getInt("seligibility") == 1){
							eligi = true;
						}
						sk2.setSeligibility(eligi);
						sk2.setSkillID(skill.getInt("sid"));
						skillArray.add(sk2);
					}
			
			
			}
		} catch (SQLException e) {
			log.debug("Get user skills failed : ", e);
		}
		return skillArray;
	}

	public ArrayList<Experience> getApplicantExp(Applicants app) {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet uExp =db.getApplicantExperience(app);
		ArrayList<Experience> expArray = new ArrayList<Experience>();
		try {
			while(uExp.next()){
				Experience sk = new Experience();
				sk.setExpid(uExp.getInt("exid"));
				
				DatabaseMethodsImpl db2 = new DatabaseMethodsImpl();
				ResultSet exp = db2.getExp(sk);
					
					while(exp.next()){
						boolean eligi = false;
						Experience exp2= new Experience();
						exp2.setExpid(exp.getInt("exid"));
						exp2.setOrganization(exp.getString("organization"));
						exp2.setDuration(exp.getInt("duration"));
						exp2.setPost(exp.getString("post"));
						
						
						if(exp.getInt("exeligibility") == 1){
							eligi = true;
						}
						exp2.setExeligibility(eligi);
					
						expArray.add(exp2);
					}
			
			
			}
		} catch (SQLException e) {
			log.debug("Get user experience failed : ", e);
		}
		return expArray;
	}

	public ArrayList<Qualifications> getApplicantQualifications(Applicants app) {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet uQualifications =db.getApplicantQualifications(app);
		ArrayList<Qualifications> quaArray = new ArrayList<Qualifications>();
		try {
			while(uQualifications.next()){
				Qualifications qua = new Qualifications();
				qua.setId(uQualifications.getInt("eid"));
				
				DatabaseMethodsImpl db2 = new DatabaseMethodsImpl();
				ResultSet qua2 = db2.getQualifications(qua);
					
					while(qua2.next()){
						boolean eligi = false;
						Qualifications qua3= new Qualifications();
						qua3.setId(qua2.getInt("eid"));
						qua3.setInstitute(qua2.getString("institute"));
						qua3.setName(qua2.getString("name"));
						qua3.setqClass(qua2.getString("class"));
						
						
						if(qua2.getInt("eeligibility") == 1){
							eligi = true;
						}
						qua3.setQualificationsEligibility(eligi);
					
						quaArray.add(qua3);
					}
			
			
			}
		} catch (SQLException e) {
			log.debug("Get user qualifcations failed : ", e);
		}
		return quaArray;
	}
	public ArrayList<Skills> getSkillAll() {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet skills =db.getSkillAll();
		ArrayList<Skills> skillArray = new ArrayList<Skills>();
		try {
				
					while(skills.next()){
						boolean eligi = false;
						Skills sk2= new Skills();
						sk2.setSkill(skills.getString("name"));
						if(skills.getInt("seligibility") == 1){
							eligi = true;
						}
						sk2.setSeligibility(eligi);
						sk2.setSkillID(skills.getInt("sid"));
						skillArray.add(sk2);
					}
			
					log.debug("Get All skills Successful");

			
		} catch (SQLException e) {
			log.debug("Get All skills failed : ", e);
		}
		return skillArray;
	}

	public ArrayList<Experience> getExpAll() {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet exp =db.getExpAll();
		ArrayList<Experience> expArray = new ArrayList<Experience>();
		try {
		
					
					while(exp.next()){
						boolean eligi = false;
						Experience exp2= new Experience();
						exp2.setExpid(exp.getInt("exid"));
						exp2.setOrganization(exp.getString("organization"));
						exp2.setDuration(exp.getInt("duration"));
						exp2.setPost(exp.getString("post"));
						
						
						if(exp.getInt("exeligibility") == 1){
							eligi = true;
						}
						exp2.setExeligibility(eligi);
					
						expArray.add(exp2);
					}
					log.debug("Get All experience Successful ");
			
	
		} catch (SQLException e) {
			log.debug("Get All experience failed : ", e);
		}
		return expArray;
	}


	public ArrayList<Qualifications> getQualificationsAll() {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet AQualifications =db.getQualificationsAll();
		ArrayList<Qualifications> qualificationsAllArray = new ArrayList<Qualifications>();
		try {
	
					while(AQualifications.next()){
						boolean eligi = false;
						Qualifications qualificationsAll= new Qualifications();
						qualificationsAll.setId(AQualifications.getInt("eid"));
						qualificationsAll.setInstitute(AQualifications.getString("institute"));
						qualificationsAll.setName(AQualifications.getString("name"));
						qualificationsAll.setqClass(AQualifications.getString("class"));
						
						
						if(AQualifications.getInt("eeligibility") == 1){
							eligi = true;
						}
						qualificationsAll.setQualificationsEligibility(eligi);
					
						qualificationsAllArray.add(qualificationsAll);
					}
					log.debug("Get All qualifcations Successful  ");
			
			
		} catch (SQLException e) {
			log.debug("Get All qualifcations failed : ", e);
		}
		return qualificationsAllArray;
	}
	
	public int trainSkillsNN() {
	//	if(flagS == true){
        int result = 0;
			NNSkillModelImpl skillNN = new NNSkillModelImpl();
			log.debug("Training Skill Neural Network : ");
		//	flagS = false;
			log.debug("Skill Neural Network Flag set to False ");
				if(skillNN.trainAndSaveModel()==1){
				//	flagS = true;
                                result=1;
					log.debug("Skill Neural Network Flag set to True ");
				}
		//	}
                return result;
	}
		
	public int trainQualificationsExperienceNN() {
		//if(flagQE == true){
                    int result = 0;
			log.debug("Training Experience + Qualifications Neural Network ");
		NNQualificationsAndExperienceImpl b = new NNQualificationsAndExperienceImpl();
		//flagQE = false;
		log.debug("Experience + Qualifications Neural Network Flag set to False ");
			if(b.trainAndSaveModel()==1)
                        {
                            result=1;
				//flagQE = true;
				log.debug("Experience + Qualifications Neural Network Flag set to True ");
			}
		return result;
		
		
	}


	public int evaluateApplicant(Applicants app) {
		int response = 0 ;
		double skillScore = 0.0;
		double expQuaScore = 0.0;
		double finalScore = 0.0;
		NNQualificationsAndExperienceImpl expQua = new NNQualificationsAndExperienceImpl();
		expQuaScore= expQua.loadAndEvaluateModel(app);
		NNSkillModelImpl skillNN = new NNSkillModelImpl();
		skillScore=skillNN.loadAndEvaluateModel(app);
		
		finalScore = skillScore + expQuaScore;
		
		Job j = new Job();
		j.setExpQuaScore(expQuaScore);
		j.setSkillScore(skillScore);
		j.setJobid(1);
		j.setFinalScore(finalScore);
		
		DatabaseMethodsImpl dbInstance = new DatabaseMethodsImpl();
		if(dbInstance.addApplicantJob(app, j)==1){
			response=1;
		}
		log.debug("Applicant Evaluated");
		return response;
	}

	public ArrayList<Job> getUserJobInfo(Applicants app) {
	DatabaseMethodsImpl db = new DatabaseMethodsImpl();
	ResultSet rs = db.getUserJobStatus(app);
	ArrayList<Job> userJobArray = new ArrayList<Job>();
	try{
	while(rs.next()){
		Job job = new Job();
		job.setApplicantID(rs.getInt("id"));
		job.setJobid(rs.getInt("jid"));
		job.setExpQuaScore(rs.getDouble("expQuaScore"));
		job.setSkillScore(rs.getDouble("skillScore"));
		job.setFinalScore(rs.getDouble("eligibilityFinal"));
		
		userJobArray.add(job);
		}
	log.debug("Getting User Job Statistics");
	}catch (Exception e){
		log.debug("Getting User Job Statistics failed",e);
	}
	log.debug("Got User Job Statistics");
		return userJobArray;
	}

	public int deleteJob(Job job) {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		return db.deleteJob(job);
	}

	public int addUserJob(Applicants app, Job job) {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		return db.addApplicantJob(app, job);
		 
	}

	public int addUserSkills(Applicants app, Skills skill) {
		int result = 0;
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		BOLMethodsImpl bl = new BOLMethodsImpl();
		for(int i=0;i< skill.getSkillName().size();i++){
			try {Skills sk = new Skills();
			sk.setSkill(skill.getSkillName().get(i));
			if(bl.addSkills(sk)==1){
				System.out.println("new skills added");
				log.debug("new skill added");
			}else{
				System.out.println("skill aleady exists");
				log.debug("skill aleady exists");

			}
			ResultSet r = db.getSkills(sk);
		
				while(r.next()){
				sk.setSkillID(r.getInt("sid"));
			result=+ db.addApplicantSkills(app, sk);
				log.debug("applicant skill #"+i+ " added");
				}
				} catch (SQLException e) {
					log.debug("Adding applicant skills failed",e);
			}
		
		}
                skill.setSkillName(null);
		return result;
	}

	public int addUserQualifications(Applicants app, Qualifications qua) {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		BOLMethodsImpl bl = new BOLMethodsImpl();
		int result = 0 ;
		
		try {
			bl.addQualifications(qua) ;
			ResultSet q = db.getQualifications(qua);
			Qualifications qualification = new Qualifications();
			q.next();
			qualification.setId(q.getInt("eid"));
			result = db.addApplicantQualifcations(app, qualification);
		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Adding applicant qualifications failed",e);
		}
		
		return result;
	}

	public int addUserExperience(Applicants app, Experience exp) {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		BOLMethodsImpl bl = new BOLMethodsImpl();
		int result = 0 ;
		
		try {
			if(bl.addExperience(exp) == 1){
				log.debug("new experience added" );
			}
			ResultSet q = db.getExp(exp);
			Experience ex = new Experience();
			q.next();
			ex.setExpid(q.getInt("exid"));
			result = db.addApplicantExp(app, ex);
		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Adding applicant experience failed",e);
		}
		
		return result;
	}

	public ArrayList<Job> getUserEvaluationAll() {
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();
		ResultSet rs = db.getUserEvaluationAll();
		ArrayList<Job> userAllJobArray = new ArrayList<Job>();
		try{
		while(rs.next()){
			Job job = new Job();
			job.setApplicantID(rs.getInt("id"));
			job.setJobid(rs.getInt("jid"));
			String z = rs.getString("expQuaScore");
			job.setExpQuaScore(rs.getDouble("expQuaScore"));
			job.setSkillScore(rs.getDouble("skillScore"));
			job.setFinalScore(rs.getDouble("eligibilityFinal"));
			
			userAllJobArray.add(job);
			}
		log.debug("Getting All Users  Job Statistics ordered list");
		}catch (Exception e){
			log.debug("Getting All Users  Job Statistics ordered lists failed",e);
		}
		log.debug("Got All Users Job Statistics ordered list");
			return userAllJobArray;
	}

	public int addUserInformation(Applicants app, Job job, Qualifications qua, Experience exp,Skills skill) {
		int r = 0 ;
		BOLMethodsImpl b  = new BOLMethodsImpl();
		// r=r + b.addUserJob( app,  job);    
		r=r + b.addUserSkills( app, skill);      
		r=r + b.addUserQualifications( app,  qua);
		r=r + b.addUserExperience( app,  exp);
		r=r + b.evaluateApplicant(app);
		EmailClient email = new EmailClient();
		email.sendEmail(app, job);
		return r;
	}

	public boolean checkUserJob(Job job, Applicants app) {
		DatabaseMethodsImpl b  = new DatabaseMethodsImpl();
		ResultSet z = b.checkUserJob(app, job);
		boolean response = false;
		try {
			if(z.next()){
				response = true;
			}else{
				response= false;
			}
		} catch (SQLException e) {
			log.debug("failed to if user has already applied for the same job",e);
		}
		return response;
	}


	public int evaluateAllApplicants() {
		
		int response = 0 ;
		DatabaseMethodsImpl db = new DatabaseMethodsImpl();

		ResultSet rs = db.getUserEvaluationAll();
		try {
			while(rs.next()){
				Applicants app = new Applicants();
				app.setAppID(rs.getInt("id"));
			double skillScore = 0.0;
			double expQuaScore = 0.0;
			double finalScore = 0.0;
			NNQualificationsAndExperienceImpl expQua = new NNQualificationsAndExperienceImpl();
			expQuaScore= expQua.loadAndEvaluateModel(app);
			NNSkillModelImpl skillNN = new NNSkillModelImpl();
			skillScore=skillNN.loadAndEvaluateModel(app);
			
			finalScore = skillScore + expQuaScore;
			
			Job j = new Job();
			j.setExpQuaScore(expQuaScore);
			j.setSkillScore(skillScore);
			j.setJobid(1);
			j.setFinalScore(finalScore);
			
			DatabaseMethodsImpl dbInstance = new DatabaseMethodsImpl();
			if(dbInstance.updateEvaluatedApplicant(app, j)==1){
				response+=1;
			}
			}
		} catch (SQLException e) {
			log.debug("Applicant Re-Evaluation failed ",e);
		}
		log.debug("Applicant Evaluated");
		
		
		
		
		return response;
	}







}
