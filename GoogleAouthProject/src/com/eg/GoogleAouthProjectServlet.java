package com.eg;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@SuppressWarnings("serial")
public class GoogleAouthProjectServlet  {
	public void MailAPI(String toEmail){
		String fromEmail = "kalpana.krishna@a-cti.com";
		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);
		  try{
			  MimeMessage message = new MimeMessage(session);
			  message.setFrom(new InternetAddress(fromEmail));
			  message.addRecipient(Message.RecipientType.TO,
                      new InternetAddress(toEmail));
			  message.addRecipient(Message.RecipientType.CC,
                      new InternetAddress("kalpana.krishna@a-cti.com"));
			  message.setSubject("Your leave Request");
			  message.setContent("Hi,<br> This is your Leave Request Has been +commentswho", "text/html; charset=utf-8");
			  Transport.send(message);
			  System.out.println("demo 234 e f f f ");
		  }catch(Exception e){
			  System.out.println(e);
		  }
		
		
	}
}
