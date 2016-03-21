// File Name SendHTMLEmail.java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmailTest
{
	public static void main(String [] args)
	{
		//place holders not use your real info
		final String userName = "name@gmail.com";
		final String pass = "password";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, pass);
			}
		});
		
		try{
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress("amandamc727@gmail.com"));

			// Set To: header field of the header.
			  message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("ctorices@emich.edu, amccart8@emich.edu, fmahmood@emich.edu, cgallari@emich.edu, gduong@emich.edu"));

			// Set Subject: header field
			message.setSubject("Hello.....Its Me");

			// Send the actual HTML message, as big as you like
			message.setContent("<h1>Can now send emails for project!!!!</h1>", "text/html" );

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		}catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}


