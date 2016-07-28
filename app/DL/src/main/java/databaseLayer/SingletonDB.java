package databaseLayer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
public class SingletonDB {

	private static SingletonDB db = null ;
	private Connection instance = null;
	public static int x;
	
	private SingletonDB() {
		try{
		 
		 InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("conf.xml");
		 org.w3c.dom.Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(input));
		 XPath xpath = XPathFactory.newInstance().newXPath();
		 String DB_URL = (String) xpath.compile("//config//jdbc//url").evaluate(document, XPathConstants.STRING);
		 String JDBC_DRIVER = (String) xpath.compile("//config//jdbc//driver").evaluate(document, XPathConstants.STRING);
		 String USER = (String) xpath.compile("//config//jdbc//username").evaluate(document, XPathConstants.STRING);
		 String PASS = (String) xpath.compile("//config//jdbc//password").evaluate(document, XPathConstants.STRING);	
		 //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      instance = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getInstance(){
		
		db = new SingletonDB();
		return db.instance;
	}
		
}
