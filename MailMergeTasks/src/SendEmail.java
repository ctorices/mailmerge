//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class SendEmail {
//
//	public static void main(String [] args){
//
//		ParseHTML parseHtml = new ParseHTML();
//		Stack letters = parseHtml.getEmailLetterStack();
//
//		//login info
//		final String userName = "";
//		final String pass = "";
//
//		//using googles SMTP server to send email's
//		Properties props = new Properties();
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.socketFactory.port", "465");
//		props.put("mail.smtp.socketFactory.class",
//				"javax.net.ssl.SSLSocketFactory");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.port", "465");
//
//		Session session = Session.getDefaultInstance(props,
//				new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(userName, pass);
//			}
//		});
//
//		try{
//
//			Transport transport = session.getTransport();
//			transport.connect();
//
//			while(!letters.isEmpty()){
//				//Default MimeMessage object
//				MimeMessage message = new MimeMessage(session);
//
//				//Set From
//				message.setFrom(new InternetAddress("Geoffrey Duong <duongg4848@gmail.com>"));
//
//				//Set reply to 
//				message.setReplyTo(new javax.mail.Address[] {
//						new javax.mail.internet.InternetAddress("duongg4848@gmail.com")
//				});
//
//				//Send to
//				message.addRecipient(Message.RecipientType.TO, new InternetAddress(letters.peek().getEmail()));
//
//				//Subject
//				message.setSubject("Mail Merge Test");
//
//				//Set the HTML message
//				message.setContent(letters.peek().getLetter(), "text/html" );
//
//
//				//Send message
//				message.saveChanges();
//				transport.sendMessage(message, message.getAllRecipients());
//				System.out.println("Sent message successfully....");
//
//				letters.pop();
//
//			}
//			transport.close();
//
//		}catch (MessagingException mex) {
//			mex.printStackTrace();
//		}
//	}
//}
//}
