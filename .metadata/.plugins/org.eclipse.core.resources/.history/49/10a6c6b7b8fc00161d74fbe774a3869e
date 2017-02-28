package com.testing.utils;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

/**
 * Contains functions regarding the email verification process
 * 
 * @author Ashraf Iftekhar, Feb 3, 2017
 *
 */
public class ReadVerificationEmail {

	static String Content = "";
	static String Code = "";

	/**
	 * Provides email verification code received on an email
	 * 
	 * @param Email
	 * @param Password
	 * @return Code
	 */
	public static String emailReader(String Email, String Password) {
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");
		try {
			Session session = Session.getInstance(props, null);
			Store store = session.getStore();
			store.connect("imap.gmail.com", Email, Password);
			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);
			Message msg = inbox.getMessage(inbox.getMessageCount());
			if (msg.getSubject() != null) {
				Multipart mp = (Multipart) msg.getContent();
				for (int i = 0; i < mp.getCount(); i++) {
					BodyPart bp = mp.getBodyPart(i);
					if (bp.getContent().toString().contains("code=")) {
						Content = bp.getContent().toString();
						String[] str = Content.split("code=", 2);
						String[] str2 = str[1].split('"' + ">", 2);
						Code = str2[0];
					}
				}
			} else {
				System.out.println("Email Not Found");
			}

		} catch (Exception mex) {
			mex.printStackTrace();
		}
		System.out.println("New Accessed Code = " + Code);
		return Code;

	}

}
