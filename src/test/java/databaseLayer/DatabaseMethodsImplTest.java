/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author VABAYJE
 */ @FixMethodOrder(MethodSorters.JVM)
public class DatabaseMethodsImplTest extends TestCase {
    
    public DatabaseMethodsImplTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
   

   

    @Test
    public void firstTest() {
       testAddAdmin();
    }

    @Test
    public void secondTest() {
      testDeleteAdmin();
    }
    /**
     * Test of addApplicant method, of class DatabaseMethodsImpl.
     */
    public void testAddApplicant() {
        System.out.println("addApplicant");
        Applicants app = new Applicants();
                app.setName("UnitTesting");
		app.setBirthDate("09/02/2291");
		app.setContactNo("0881231231");
		app.setEmail("asdasd@Aasd.com");
		app.setNicNo("0010101010v");
		app.setUsername("UnitTestingUsername");
		app.setPassword("UnitTestingPassword");
        DatabaseMethodsImpl instance = new DatabaseMethodsImpl();
        int expResult = 1;
        int result = instance.addApplicant(app);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of deleteApplicant method, of class DatabaseMethodsImpl.
     */
    public void testDeleteApplicant() {
         System.out.println("deleteApplicant");
        Applicants app = new Applicants();
        app.setUsername("UnitTestingUsername");
        DatabaseMethodsImpl instance = new DatabaseMethodsImpl();
        ResultSet resultset=instance.getApplicantDetails(app);
        int id=0;
        try {
			while(resultset.next()){
				id = Integer.parseInt(resultset.getString("description"));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        app.setAppID(id);
        int expResult = 1;
        int result = instance.deleteApplicant(app);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of addAdmin method, of class DatabaseMethodsImpl.
     */
    public void testAddAdmin() {
        System.out.println("addAdmin");
        Admin admin = new Admin();
        
        	 admin.setName("UNITTESTING");
		 admin.setContactNo("0881231231");
		 admin.setEmail("asdasd@Aasd.com");
		 admin.setUsername("UNITTESTING");
		 admin.setPassword("UNITTESTING");
		 admin.setJoinedDate("22/22/2220");
                 admin.setEmpNo("0011");
		
        DatabaseMethodsImpl instance = new DatabaseMethodsImpl();
        
        int expResult = 1;
        
        int result = instance.addAdmin(admin);
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
       public void testDeleteAdmin() {
      System.out.println("deleteAdmin");
        Admin admin = new Admin();
              admin.setUsername("UNITTESTING");
		
		
        DatabaseMethodsImpl instance = new DatabaseMethodsImpl();
        int expResult = 1;
        int result = instance.deleteAdmin(admin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addSkills method, of class DatabaseMethodsImpl.
     */
/*    public void testAddSkills() {
        System.out.println("addSkills");
        Applicants app = null;
        Skills skill = null;
        DatabaseMethodsImpl instance = new DatabaseMethodsImpl();
        int expResult = 0;
        int result = instance.addSkills(app, skill);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    *//**
     * Test of checkApplicantUsername method, of class DatabaseMethodsImpl.
     *//*
    public void testCheckApplicantUsername() {
        System.out.println("checkApplicantUsername");
        Applicants app = null;
        DatabaseMethodsImpl instance = new DatabaseMethodsImpl();
        boolean expResult = false;
        boolean result = instance.checkApplicantUsername(app);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    *//**
     * Test of getApplicantDetails method, of class DatabaseMethodsImpl.
     *//*
    public void testGetApplicantDetails() {
        System.out.println("getApplicantDetails");
        Applicants app = null;
        DatabaseMethodsImpl instance = new DatabaseMethodsImpl();
        ArrayList<Applicants> expResult = null;
        ArrayList<Applicants> result = instance.getApplicantDetails(app);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    *//**
     * Test of getAdminDetails method, of class DatabaseMethodsImpl.
     *//*
    public void testGetAdminDetails() {
        System.out.println("getAdminDetails");
        Admin admin = null;
        DatabaseMethodsImpl instance = new DatabaseMethodsImpl();
        ArrayList<Admin> expResult = null;
        ArrayList<Admin> result = instance.getAdminDetails(admin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    *//**
     * Test of getSkillDetails method, of class DatabaseMethodsImpl.
     *//*
    public void testGetSkillDetails() {
        System.out.println("getSkillDetails");
        Applicants app = null;
        DatabaseMethodsImpl instance = new DatabaseMethodsImpl();
        ArrayList<Skills> expResult = null;
        ArrayList<Skills> result = instance.getSkillDetails(app);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
