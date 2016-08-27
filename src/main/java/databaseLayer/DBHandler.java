/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author VABAYJE
 */
public class DBHandler {
    
    public static void main(String[] args){
//        String query = null;
//        query = "INSERT INTO ingrow.applicant (name,birthDate,ContactNo,email,username,password )"
//                + "VALUES('jeewantha','01/01/0001','00000000','asd@gmail.com','username1','password')";
//        DBHandler b = new DBHandler();
//        try{
//        System.out.println(b.insert(query));
//    }catch(Exception e){
//        System.out.println("exception :" + e);
//    }
  }
    
    public int insert(String query) throws Exception {
          
        Connection conn = SingletonDB.getInstance();

        Statement stmt = conn.createStatement();
        int x = stmt.executeUpdate(query);
        conn.close();
        return x;
    }



    public ResultSet getdata(String query) {
        try {
            Connection conn = SingletonDB.getInstance();
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(query);
            
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}
