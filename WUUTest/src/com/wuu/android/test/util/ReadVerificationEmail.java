package com.wuu.android.test.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Contains functions regarding the email verification process
 * 
 * @author Ashraf Iftekhar, Feb 3, 2017
 *
 */
public class ReadVerificationEmail {

	static String host = "smtp.mail.yahoo.com";
	static String port = "587";
	static String emailid = "mmtesters@yahoo.com";
	static String password = "Password123$";
	static String Content = "";
	static String Code = "";
	static Properties props = System.getProperties();
	static Session l_session = null;

	/**
	 * Provides email verification code received on an email
	 * 
	 * @param Email
	 * @param Password
	 * @return Code
	 * @throws MessagingException
	 */
	public static void main(String[] args) throws MessagingException {

		// Sender's email ID needs to be mentioned
		String from = "mmtesters@yahoo.com";
		String pass = "Password123$";
		// Recipient's email ID needs to be mentioned.
		String to = "ashrafrizvi3006@gmail.com";
		String host = "smtp.mail.yahoo.com";

		// Get system properties
		Properties properties = System.getProperties();
		// Setup mail server
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.user", from);
		properties.put("mail.smtp.password", pass);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			// Send message
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
