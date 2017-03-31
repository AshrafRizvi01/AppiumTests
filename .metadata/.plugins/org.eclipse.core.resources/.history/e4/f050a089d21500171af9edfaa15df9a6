package com.test.utils;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Provides email mechanism to send the report by email to the team members
 * 
 * @author Ashraf Iftekhar, Mar 30, 2017
 *
 */
public class EmailReport {

	/**
	 * Sends Email with a report attached to it.
	 * 
	 * @param EmailIds
	 *            String[]
	 * @param SenderEmail
	 *            String
	 * @param reportName
	 *            String
	 */
	public static void SendReportAsEmail(String[] EmailIds) {
		// Recipient's email ID needs to be mentioned.
		// Sender's email ID needs to be mentioned
		String from = "mmtesters@yahoo.com";
		String pass = "Password123$";
		// Recipient's email ID needs to be mentioned.
		;
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
			for (int i = 0; i < EmailIds.length; i++) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(EmailIds[i]));
			}

			// Set Subject: header field
			message.setSubject("TEST REPORT" + " | Framework Generated Report");
			Date dt = new Date();
			Multipart multipart = new MimeMultipart();
			BodyPart textpart = new MimeBodyPart();
			// Now set the actual message
			multipart.addBodyPart(textpart);

			textpart.setText("Please find the attached report" + "\n" + "This report was generated at " + dt.toString()
					+ "\n" + "Testing Team" + "\n" + "Thank You");

			String filename = System.getProperty("user.dir") + "/" + "report.html";
			// Multipart multipart = new MimeMultipart();

			BodyPart messageBodyPart = new MimeBodyPart();
			DataSource ds = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(ds));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);
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
