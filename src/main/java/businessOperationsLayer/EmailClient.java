package businessOperationsLayer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import databaseLayer.Applicants;
import databaseLayer.Job;


public class EmailClient {
	  private static final Logger log = Logger.getLogger(EmailClient.class);
	public static void main(String[] args) throws IOException {
	
	}
	public int sendEmail (Applicants app, Job job) {
		try{
        Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.socketFactory.port", "465");
	props.put("mail.smtp.socketFactory.class",
			"javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", "465");
  
	InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("email.txt");
	BufferedReader in = new BufferedReader(new InputStreamReader(input));
	String line;
	
	final String username = in.readLine();
	
	final String password= in.readLine();
	
	in.close();
	Session session = Session.getInstance(props,
		new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
	StringBuffer receps = new StringBuffer();
	String currentEmail = null;
	try {
		InputStream input2 = Thread.currentThread().getContextClassLoader().getResourceAsStream("emailSendTo.txt");
		BufferedReader in2 = new BufferedReader(new InputStreamReader(input2));
		while((currentEmail=in2.readLine() ) != null){
			receps.append("," + currentEmail);
		}
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(receps.toString()));
		message.setSubject("New Application");
		message.setText("\n\n An application was sent by '"  + app.getName() +"' for the job ID '"+ job.getJobid() +"' \n\n Thanks and Regards, \n Project InGrow "
                
                );

		Transport.send(message);

		System.out.println("Done");
		

	} catch (MessagingException e) {
		log.debug("Email Sending Failed",e);
	}
	  
		}catch (Exception e){
			
		}
	return 1 ; }
	
}
