package databaseLayer;

import java.io.IOException;
import java.util.Properties;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;


public class dbcon {
	


	 public static void main(String[] args) throws SQLException, IOException, XPathExpressionException, SAXException, ParserConfigurationException {
		 

		 Connection conn =null;
		 try{ String sql;
	      sql = "SELECT * FROM applicant";
		       conn = SingletonDB.getInstance();
	            Statement st = conn.createStatement();
	            ResultSet result = st.executeQuery(sql);
	            
		      //STEP 5: Extract data from result set
		      while(result.next()){
		         //Retrieve by column name
		         int age = result.getInt("age");
		         String last = result.getString("name");

		         //Display values
		         System.out.print("Age: " + age);
		         System.out.println(", Last: " + last);
		      }
		      //STEP 6: Clean-up environment
		      result.close();
		/*      stmt.close();*/
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");

	 }
		   
}
