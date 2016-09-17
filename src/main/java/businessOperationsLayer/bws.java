/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessOperationsLayer;

import databaseLayer.*;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author VABAYJE
 */
@WebService(serviceName = "bws")
public class bws {

@WebMethod(operationName = "RegisterUser")
   public int RegisterUser(@WebParam(name = "userObj") Applicants app) {
       BOLMethodsImpl obj = new BOLMethodsImpl();
       
       return obj.RegisterUser(app) ;
       
   }
    
    @WebMethod(operationName = "RegisterAdmin")
    public int RegisterAdmin(@WebParam(name = "adminObj") Admin admin) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.RegisterAdmin(admin) ;
        
    }
   
    @WebMethod(operationName = "checkUserJob")
    public boolean checkUserJob(@WebParam(name = "jobObj")Job job, @WebParam(name = "appObj")Applicants app) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.checkUserJob(job,app) ;
        
    }
    
    @WebMethod(operationName = "deleteAdmin")
    public int deleteAdmin(@WebParam(name = "adminObj") Admin admin) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.deleteAdmins(admin) ;
        
    }
    
    @WebMethod(operationName = "deleteUser")
    public int deleteUser(@WebParam(name = "userObj") Applicants app) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.deleteUsers(app) ;
        
    }
    
    @WebMethod(operationName = "LoginUser")
    public String LoginUser(@WebParam(name = "userObj") Users app) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.LoginUser(app) ;
        
    }
    
   
    
    @WebMethod(operationName = "addSkills")
    public int addSkills(@WebParam(name = "skillObj") Skills skill) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.addSkills(skill) ;
        
    }
    
     @WebMethod(operationName = "addExperience")
    public int addExperience(@WebParam(name = "expObj") Experience exp) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.addExperience(exp) ;
        
    }
    
      @WebMethod(operationName = "addQualifications")
    public int addQualifications(@WebParam(name = "quaObj") Qualifications qualification) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.addQualifications(qualification) ;
        
    }
    
         @WebMethod(operationName = "addJob")
    public int addJob(@WebParam(name = "jobObj") Job job) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.addJob(job) ;
        
    }
    
          @WebMethod(operationName = "updateSkills")
    public int updateSkills(@WebParam(name = "skillObj") Skills skill) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.updateSkills(skill) ;
        
    }
    
            @WebMethod(operationName = "updateExperience")
    public int updateExperience(@WebParam(name = "expObj") Experience exp) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.updateExperience(exp) ;
        
    }
    
              @WebMethod(operationName = "updateQualifications")
    public int updateQualifications(@WebParam(name = "quaObj") Qualifications qualification) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.updateQualifications(qualification) ;
        
    }
    
           @WebMethod(operationName = "getApplicants")
    public ArrayList<Applicants> getApplicants(@WebParam(name = "appObj") Applicants app) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.getApplicants(app) ;
        
    }
    
      
           @WebMethod(operationName = "getJobInfo")
    public ArrayList<Job> getJobInfo(@WebParam(name = "appObj") Job job) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.getJobInfo(job) ;
        
    }
    
            @WebMethod(operationName = "getAdminInfo")
    public ArrayList<Admin> getAdminInfo(@WebParam(name = "adminObj") Admin admin) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.getAdminInfo(admin) ;
        
    }
    
             @WebMethod(operationName = "getUserJobInfo")
    public ArrayList<Job> getUserJobInfo(@WebParam(name = "appObj") Applicants app) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.getUserJobInfo(app) ;
        
    }
    
               @WebMethod(operationName = "getUserEvaluationAll")
    public ArrayList<Job> getUserEvaluationAll() {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.getUserEvaluationAll() ;
        
    }
    
               @WebMethod(operationName = "getSkillInfo")
    public ArrayList<Skills> getSkillInfo(@WebParam(name = "skillObj") Skills skill) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.getSkillInfo(skill) ;
        
    }
                @WebMethod(operationName = "getExpInfo")
    public ArrayList<Experience> getExpInfo(@WebParam(name = "expObj") Experience exp) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.getExpInfo(exp) ;
        
    }
                    @WebMethod(operationName = "getQualificationsInfo")
    public ArrayList<Qualifications> getQualificationsInfo(@WebParam(name = "qualificationObj") Qualifications qualification) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.getQualificationsInfo(qualification) ;
        
    }
                  @WebMethod(operationName = "getApplicantSkills")
    public ArrayList<Skills> getApplicantSkills(@WebParam(name = "appObj") Applicants app) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.getApplicantSkills(app) ;
        
    }
                   @WebMethod(operationName = "getApplicantExp")
    public ArrayList<Experience> getApplicantExp(@WebParam(name = "appObj") Applicants app) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.getApplicantExp(app) ;
        
    }
                    @WebMethod(operationName = "getApplicantQualifications")
    public ArrayList<Qualifications> getApplicantQualifications(@WebParam(name = "appObj") Applicants app) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.getApplicantQualifications(app) ;
        
    }
                    @WebMethod(operationName = "getAllSkills")
    public ArrayList<Skills> getSkillAll() {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.getSkillAll() ;
        
    }
                    @WebMethod(operationName = "getExpAll")
    public ArrayList<Experience> getExpAll() {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.getExpAll() ;
        
    }
                    @WebMethod(operationName = "getQualificationsAll")
    public ArrayList<Qualifications> getQualificationsAll() {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.getQualificationsAll() ;
        
    }
                      @WebMethod(operationName = "evaluateApplicant")
    public int evaluateApplicant(@WebParam(name = "appObj") Applicants app) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.evaluateApplicant(app) ;
        
    }
    
                       @WebMethod(operationName = "deleteskill")
    public int deleteskill(@WebParam(name = "skillObj") Skills skill) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.deleteskill(skill) ;
        
    }
                          @WebMethod(operationName = "deleteExp")
    public int deleteExp(@WebParam(name = "expObj") Experience exp) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.deleteExp(exp) ;
        
    }
                             @WebMethod(operationName = "deleteQualifications")
    public int deleteQualifications(@WebParam(name = "qualificationsObj") Qualifications qualifications) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.deleteQualifications(qualifications) ;
        
    }
    
                                 @WebMethod(operationName = "deleteJob")
    public int deleteJob(@WebParam(name = "jobObj") Job job) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.deleteJob(job) ;
        
    }
                                    @WebMethod(operationName = "addUserInformation")
    public int addUserInformation(@WebParam(name = "appObj") Applicants app,@WebParam(name = "jobObj") Job job,@WebParam(name = "qualificationsObj") Qualifications qua,@WebParam(name = "expObj") Experience exp,@WebParam(name = "skillObj") Skills skill) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.addUserInformation( app,  job,  qua,  exp, skill) ;
        
    }
}
