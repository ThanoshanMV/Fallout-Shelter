package com.group2.package1;

import java.util.Date;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
	// private String otpNumberStorer;
	public static void sendEmailOTP() {
		try {
			String host = "smtp.gmail.com";
			String user = "examplejava00@gmail.com";
			String pass = "!examplejava00!";
			String to = StaticFields.emailAddressOfTheReceiver;
			String from = "Fallout_Coders";
			String subject = "Email Verification - FalloutShelter";
			String messageText = "Hey There!,We have sent you a temporary code. Your code is :- " + StaticFields.otp;
			boolean sessionDebug = false;

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");

			// java.security.Security.addProvider(new
			// com.sun.net.ssl.internal.ssl.Provider());
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(messageText);

			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("message send successfully");
			System.out.println("OTP is :- " + StaticFields.otp);

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public static void sendEmailForForgetPass() {
		try {
			String host = "smtp.gmail.com";
			String user = "examplejava00@gmail.com";
			String pass = "!examplejava00!";
			String to = StaticFields.emailAddressOfTheReceiver;
			String from = "Fallout_Coders";
			String subject = "Reply For Forgot Password - FalloutShelter";
			String messageText = "Hey There!, Next time when you login provide this temporary password. "
					+ StaticFields.temporaryPassword
					+ " This temporary password is set as current password to your account. So kindly change it as you wish. You can change it by going to Settings in Dashboard.";
			boolean sessionDebug = false;

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");

			// java.security.Security.addProvider(new
			// com.sun.net.ssl.internal.ssl.Provider());
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(messageText);

			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("message send successfully");
			System.out.println("Password is :- " + StaticFields.temporaryPassword);

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public static void sendEmailForForgetName() {
		try {
			String host = "smtp.gmail.com";
			String user = "examplejava00@gmail.com";
			String pass = "!examplejava00!";
			String to = StaticFields.emailAddressOfTheReceiver;
			String from = "Fallout_Coders";
			String subject = "Reply For Forgot Name - FalloutShelter";
			String messageText = "Hey There!, Your Fallout Shelter Account Name = " + StaticFields.userName;
			boolean sessionDebug = false;

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");

			// java.security.Security.addProvider(new
			// com.sun.net.ssl.internal.ssl.Provider());
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(messageText);

			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("message send successfully");
			System.out.println("Name is :- " + StaticFields.userName);

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public static void sendEmailForRetrieveAccount() {
		try {
			String host = "smtp.gmail.com";
			String user = "examplejava00@gmail.com";
			String pass = "!examplejava00!";
			String to = StaticFields.emailAddressOfTheReceiver;
			String from = "Fallout_Coders";
			String subject = "Protect your FalloutShelter account!";
			String messageText = "Hey " + StaticFields.UserNameForAccountRetrieve
					+ ", We've identified some suspicious activities with your account. So, Next time when you login with correctly, please provide the below number as retieval code. Cheers!. "
					+ "Retrieval Code: " + StaticFields.otpForRetrieval;
			boolean sessionDebug = false;

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");

			// java.security.Security.addProvider(new
			// com.sun.net.ssl.internal.ssl.Provider());
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(messageText);

			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("message send successfully");
			System.out.println("otp is :- " + StaticFields.otp);

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
}
