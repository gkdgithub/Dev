package com.quinnox.emailsender;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailFromOffice365 {
	
	public static void main(String args[]) {
		
		final String username = "gauravd@quinnox.com";  // like yourname@outlook.com
	    final String password = "Password$123";   // password here

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "smtp.office365.com");
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	        @Override
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	        }
	      });
	    session.setDebug(true);

	    try {

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(username));
	        message.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse("gauravgreatgaurav@gmail.com"));   // like inzi769@gmail.com
	        message.setSubject("Test");
	        message.setText("HI you have done sending mail with outlook");

	        Transport.send(message);

	        System.out.println("Done");

	    } catch (MessagingException e) {
	    	System.out.println(e.getMessage());
	        e.printStackTrace();
	    }
		
     }
	
}
