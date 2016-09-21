/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessOperationsLayer;

import databaseLayer.Admin;
import databaseLayer.Applicants;
import databaseLayer.Experience;
import databaseLayer.Job;
import databaseLayer.Qualifications;
import databaseLayer.Skills;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;

/**
 *
 * @author VABAYJE
 * 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BOLMethodsImplTest {
    
    public BOLMethodsImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    	
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of RegisterUser method, of class BOLMethodsImpl.
     */
    @Test
    public void testARegisterUser() {
        System.out.println("RegisterUser");
        Applicants app = new Applicants();
        app.setName("UnitTest");
        app.setBirthDate("2010-12-03");
        app.setContactNo("07712312311");
        app.setEmail("unittest@gmail.com");
        app.setUsername("unitTest");
        app.setPassword("unitTest");
        app.setRole("user");
        app.setNicNo("101010101v");
        BOLMethodsImpl b = new BOLMethodsImpl();
      
        int expResult = 1;
        int result =  b.RegisterUser(app);
        assertEquals(expResult, result);
      
        
    }

    /**
     * Test of RegisterAdmin method, of class BOLMethodsImpl.
     */
    @Test
    public void testBRegisterAdmin() {
        System.out.println("RegisterAdmin");
        Admin admin = new Admin();
        admin.setName("UnitTest");
        admin.setEmpNo("123123");
        admin.setContactNo("07712312311");
        admin.setEmail("unittest@gmail.com");
        admin.setUsername("unitTestADMINUSERNAME");
        admin.setPassword("unitTestADMINPW");
        admin.setRole("admin");
       
        BOLMethodsImpl instance = new BOLMethodsImpl();
        int expResult = 1;
        int result = instance.RegisterAdmin(admin);
        assertEquals(expResult, result);
 
    }

    /**
     * Test of LoginUser method, of class BOLMethodsImpl.
     */
    @Test
    public void testCLoginUser() {
        System.out.println("LoginUser");
        Applicants app = new Applicants();
        app.setUsername("unitTest");
        app.setPassword("unitTest");
        BOLMethodsImpl instance = new BOLMethodsImpl();
        int expResult = 1;
        int result = 0;
        String x = instance.LoginUser(app);
        if(x !="fail"){
            result = 1;
        }
        assertEquals(expResult, result);
   
    }

 
    /**
     * Test of add job  method, of class BOLMethodsImpl.
     */
    @Test
    public void testEAddJob() {
        System.out.println("addJob");
        Job job = new Job();
	    job.setJobDescription("UnitTestDesc");
	    job.setName("unitTest");
        BOLMethodsImpl instance = new BOLMethodsImpl();
        
        int result = instance.addJob(job);
        int expResult = 1;
        assertEquals(expResult, result);
     
    }
    /**
     * Test of addSkills method, of class BOLMethodsImpl.
     */
    @Test
    public void testFAddSkills() {
        System.out.println("addSkills");
        Skills skill = new Skills();
        skill.setSeligibility(false);
        skill.setSkill("UnitTestSkill");
        BOLMethodsImpl instance = new BOLMethodsImpl();
        int expResult = 1;
        int result = instance.addSkills(skill);
        assertEquals(expResult, result);
     
    }
    
      /**
     * Test of addExperience method, of class BOLMethodsImpl.
     */
    @Test
    public void testGAddExperience() {
        System.out.println("addExperience");
        Experience exp = new Experience();
        exp.setOrganization("unitTestExp");
        exp.setPost("unitTestPost");
        exp.setDuration(2);
        BOLMethodsImpl instance = new BOLMethodsImpl();
        int expResult = 1;
        int result = instance.addExperience(exp);
        assertEquals(expResult, result);
     
    }

    /**
     * Test of addQualifications method, of class BOLMethodsImpl.
     */
    @Test
    public void testHAddQualifications() {
        System.out.println("addQualifications");
        Qualifications qualification =  new Qualifications();
        qualification.setName("unitTestQualification");
        qualification.setInstitute("unitTestInstititue");
        qualification.setqClass("unitTestClass");
        BOLMethodsImpl instance = new BOLMethodsImpl();
        int expResult = 1;
        int result = instance.addQualifications(qualification);
        assertEquals(expResult, result);
      
    }


    /**
     * Test of updateSkills method, of class BOLMethodsImpl.
     */
    @Test
    public void testIUpdateSkills() {
        System.out.println("updateSkills");
        Skills skill = new Skills();
        skill.setSkill("UnitTestSkill");
        skill.setSeligibility(true);
        BOLMethodsImpl instance = new BOLMethodsImpl();
        int expResult = 1;
        int result = instance.updateSkills(skill);
        assertEquals(expResult, result);
       
    }
    
    			// GET METHODS TESTS 
    
    @Test
    public void testJgetSkillInfo() {
        System.out.println("getSKillInfo");
        Skills skill = new Skills();
        BOLMethodsImpl instance = new BOLMethodsImpl();
        skill.setSkill("UnitTestSkill");
        String expResult = "UnitTestSkill";
        String result =  instance.getSkillInfo(skill).get(0).getSkill();
       assertEquals(expResult, result);
    
    }
       @Test
    public void testKgetExpInfo() {
        System.out.println("getExpInfo");
        Experience exp = new Experience();
        BOLMethodsImpl instance = new BOLMethodsImpl();
        exp.setOrganization("unitTestExp");
        exp.setPost("unitTestPost");
        exp.setDuration(2);
        String expResult = "unitTestExp";
        String result =  instance.getExpInfo(exp).get(0).getOrganization();
       assertEquals(expResult, result);
    
    }
    @Test
    public void testLgetQualificationsInfo() {
        System.out.println("getQualificationsInfo");
       
        BOLMethodsImpl instance = new BOLMethodsImpl();
        Qualifications qualification =  new Qualifications();
        qualification.setName("unitTestQualification");
        qualification.setInstitute("unitTestInstititue");
        qualification.setqClass("unitTestClass");
        String expResult = "unitTestQualification";
        String result =  instance.getQualificationsInfo(qualification).get(0).getName();
       assertEquals(expResult, result);
    
    }
    /**
     * Test of getJobInfo method, of class BOLMethodsImpl.
     */
    @Test
    public void testMGetJobInfo() {
        System.out.println("getJobInfo");
        Job job = new Job();
	    job.setJobDescription("UnitTestDesc");
	    job.setName("unitTest");
        BOLMethodsImpl instance = new BOLMethodsImpl();
        String expResult = "unitTest";
        String result = instance.getJobInfo(job).get(0).getName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAdminInfo method, of class BOLMethodsImpl.
     */
    @Test
    public void testNGetAdminInfo() {
        System.out.println("getAdminInfo");
        Admin admin = new Admin();
        admin.setUsername("unitTestADMINUSERNAME");
        BOLMethodsImpl instance = new BOLMethodsImpl();
        String expResult = "admin";
        String result = instance.getAdminInfo(admin).get(0).getRole();
        assertEquals(expResult, result);
  
    }
    /**
     * Test of getApplicants method, of class BOLMethodsImpl.
     */
    @Test
    public void testOGetApplicants() {
        System.out.println("getApplicants");
        Applicants app = new Applicants();
        app.setUsername("unitTest");
       
        BOLMethodsImpl instance = new BOLMethodsImpl();
        String expResult = "unitTest";
        String result = instance.getApplicants(app).get(0).getUsername();
        assertEquals(expResult, result);
      
    }

    
    // Update Methods Check
    /**
     * Test of updateExperience method, of class BOLMethodsImpl.
     */
    @Test
    public void testPUpdateExperience() {
        System.out.println("updateExperience");
        Experience exp = new Experience();
        BOLMethodsImpl instance = new BOLMethodsImpl();
        exp.setOrganization("unitTestExp");
        exp.setPost("unitTestPost");
        exp.setDuration(2);
        int id =instance.getExpInfo(exp).get(0).getExpid();
        int expResult =1;
        Experience exp2 = new Experience();
        exp2.setExpid(id);
        exp2.setExeligibility(true);
        int result = instance.updateExperience(exp2);
        assertEquals(expResult, result);
 
    }

    /**
     * Test of updateQualifications method, of class BOLMethodsImpl.
     */
    @Test
    public void testQpdateQualifications() {
        System.out.println("updateQualifications");
        Qualifications qualification =  new Qualifications();
        qualification.setName("unitTestQualification");
        qualification.setInstitute("unitTestInstititue");
        qualification.setqClass("unitTestClass");
        
        BOLMethodsImpl instance = new BOLMethodsImpl();
        int id = instance.getQualificationsInfo(qualification).get(0).getId();
        int expResult = 1;
        
        Qualifications qualification2 = new Qualifications();
        qualification2.setId(id);
        qualification2.setQualificationsEligibility(true);
        int result = instance.updateQualifications(qualification2);
        assertEquals(expResult, result);

    }

   
  

   /**
     * Test of deleteAdmins method, of class BOLMethodsImpl.
     */
    @Test
    public void testRDeleteAdmins() {
        System.out.println("deleteAdmins");
        Admin admin = new Admin();
        admin.setUsername("unitTestADMINUSERNAME");
        admin.setRole("admin");
        BOLMethodsImpl instance = new BOLMethodsImpl();
        int expResult = 1;
        int result = instance.deleteAdmins(admin);
        assertEquals(expResult, result);

    }
	    @Test
    public void testSDeleteQualification() {
        System.out.println("delete qualifcation");
        Qualifications qualification =  new Qualifications();
        qualification.setName("unitTestQualification");
        qualification.setInstitute("unitTestInstititue");
        qualification.setqClass("unitTestClass");
        BOLMethodsImpl instance = new BOLMethodsImpl();
        int expResult = 1;
        int result = instance.deleteQualifications(qualification);
        assertEquals(expResult, result);
     
    }
	
	
    @Test
    public void testTDeleteExperience() {
        System.out.println("delete experience");
        Experience exp = new Experience();
        exp.setOrganization("unitTestExp");
        exp.setPost("unitTestPost");
        exp.setDuration(2);
        BOLMethodsImpl instance = new BOLMethodsImpl();
        int expResult = 1;
        int result = instance.deleteExp(exp);
        assertEquals(expResult, result);
     
    }
	
	/** 
	 * Test of delete skills method, of class BOLMethodsImpl.
	 */
     
	 @Test
    public void testUDeleteSkill() {
        System.out.println("delete skills");
        Skills skill = new Skills();
        skill.setSkill("UnitTestSkill");
        BOLMethodsImpl instance = new BOLMethodsImpl();
        int expResult = 1;
        int result = instance.deleteskill(skill);
        assertEquals(expResult, result);
     
    }
		    /**
     * Test of delete user method, of class BOLMethodsImpl.
     */
    @Test
    public void testVdeleteUser() {
        System.out.println("DeleteUser");
        Applicants app = new Applicants();
        app.setUsername("unitTest");
        BOLMethodsImpl b = new BOLMethodsImpl();
       
        int expResult = 1;
        int result =  b.deleteUsers(app);
        assertEquals(expResult, result);
      
        
    }
    @Test
    public void testWdeleteJob() {
        System.out.println("deleteJob");
        Job job = new Job();
	
	    job.setName("unitTest");
        BOLMethodsImpl instance = new BOLMethodsImpl();
        int expResult = 1;
        int result = instance.deleteJob(job);
        assertEquals(expResult, result);
     
    }
    @Test
    public void testXEmailClient() {
        System.out.println("Email Client");
        EmailClient instance = new EmailClient();
    	Applicants s = new Applicants();
    	s.setName("TEST EMAIL");
    	Job j = new Job();
    	j.setJobid(4);
        int expResult = 1;
        int result = instance.sendEmail(s,j);
        assertEquals(expResult, result);
     
    }
	
    
    
}
