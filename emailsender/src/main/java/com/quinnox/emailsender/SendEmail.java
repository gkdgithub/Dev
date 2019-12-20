package com.quinnox.emailsender;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
		public static void main(String[] args) {
			
			// Use this link make your google account less secure then only mail will go
			// https://www.google.com/settings/security/lesssecureapps
			
			// email ID of Recipient. 
		      String recipient1 = "gaurav10081992@gmail.com";
		      
		      String recipient2 = "yougauravtube1992@gmail.com"; 
		  
		      // email ID of  Sender. 
		      String sender = "gauravgreatgaurav@gmail.com";
		      String password="9670770983";
		  
		      // using host as localhost 
		      //String host = "localhost"; 
		  
		      // Getting system properties 
		      Properties properties = System.getProperties(); 
		  
		      // Setting up mail server 
		      //properties.setProperty("mail.smtp.host", host); 
		      
		      properties.put("mail.smtp.starttls.enable", "true"); 
		      properties.put("mail.smtp.host", "smtp.gmail.com");
		      properties.put("mail.smtp.user", sender); // User name
		      properties.put("mail.smtp.password", password); // password
		      properties.put("mail.smtp.port", "587");
		      properties.put("mail.smtp.auth", "true");
		      
		   // creates a new session with an authenticator
		        Authenticator auth = new Authenticator() {
		            public PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(sender, password);
		            }
		        };
		      
		      // creating session object to get properties 
		      Session session = Session.getDefaultInstance(properties,auth); 
		  
		      try 
		      { 
		         // MimeMessage object. 
		         MimeMessage message = new MimeMessage(session); 
		  
		         // Set From Field: adding senders email to from field. 
		         message.setFrom(new InternetAddress(sender)); 
		  
		         // Set To Field: adding recipient's email to from field. 
		         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient1));
		         message.addRecipient(Message.RecipientType.CC, new InternetAddress(recipient2));
		         
		         String subject = "Hello my friend";
		         // Set Subject: subject of the email 
		         message.setSubject(subject); 
		         
		         message.setSentDate(new Date());
		         
		      // message contains HTML markups
		         /*String body = "<i>Greetings!</i><br>";
		         body += "<b>Wish you a nice day!</b><br>";
		         body += "<font color=red>Duke</font>";*/
		         
		         String body="<html>\r\n" + 
		         		"<head>\r\n" + 
		         		"<style>\r\n" + 
		         		"table, th, td {\r\n" + 
		         		"  border: 1px solid black;\r\n" + 
		         		"  border-collapse: collapse;\r\n" + 
		         		"  padding: 5px;\r\n" + 
		         		"}\r\n" + 
		         		"</style>\r\n" + 
		         		"</head>\r\n" + 
		         		"<body>\r\n" + 
		         		"<i>Greetings!</i><br>\r\n" + 
		         		"<b>Wish you a nice day!</b><br>\r\n" + 
		         		"<center>List of monthly expenditure</center><br>\r\n" + 
		         		"\r\n" + 
		         		"<table style=\"width:50%\" align=\"center\">\r\n" + 
		         		"  <tr>\r\n" + 
		         		"    <th>Month</th>\r\n" + 
		         		"    <th>Savings</th>\r\n" + 
		         		"    <th>Actions</th>\r\n" + 
		         		"  </tr>\r\n" + 
		         		"  <tr>\r\n" + 
		         		"    <td>January</td>\r\n" + 
		         		"    <td>$100</td>\r\n" + 
		         		"    <td>N/A</>\r\n" + 
		         		"  </tr>\r\n" + 
		         		"  <tr>\r\n" + 
		         		"    <td>February</td>\r\n" + 
		         		"    <td>$80</td>\r\n" + 
		         		"    <td>N/A</>\r\n" + 
		         		"  </tr>\r\n" + 
		         		"</table><br>\r\n" + 
		         		"<b>Regards</b><br>\r\n" + 
		         		"<b>Gaurav</b><br>\r\n" + 
		         		"</body>\r\n" + 
		         		"</html>";
		         
		         // set body of the email. 
		         message.setContent(body,"text/html"); 
		  
		         // Send email. 
		         Transport.send(message); 
		         System.out.println("Mail successfully sent"); 
		      } 
		      catch (MessagingException mex)  
		      { 
		         mex.printStackTrace(); 
		      } 
			
		}
}
