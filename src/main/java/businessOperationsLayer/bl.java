/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessOperationsLayer;

import javax.jws.WebService;

import databaseLayer.Admin;
import databaseLayer.Applicants;
import databaseLayer.Skills;

import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author VABAYJE
 */
@WebService(serviceName = "bl")
public class bl {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
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
    public int LoginUser(@WebParam(name = "userObj") Applicants app) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.LoginUser(app) ;
        
    }
    
    @WebMethod(operationName = "LoginAdmin")
    public int LoginAdmin(@WebParam(name = "adminObj") Admin admin) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.LoginAdmin(admin) ;
        
    }
    
    @WebMethod(operationName = "addSkills")
    public int addSkills(@WebParam(name = "skillObj") Skills skill) {
        BOLMethodsImpl obj = new BOLMethodsImpl();
        
        return obj.addSkills(skill) ;
        
    }
    
    
    
    
}
