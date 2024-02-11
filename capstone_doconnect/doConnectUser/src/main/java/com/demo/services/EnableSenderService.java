package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;

@Service
public class EnableSenderService {

	/**
	 * @see this is the email service layer
	 * @author Vishal Bharti
	 * @since 03-Jan-2022
	 */
	@Autowired
	private JavaMailSender mailsender;

	/**
	 * 
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public void sendEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("neerajshekhawat19@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);

		mailsender.send(message);

		System.out.println("Mail sent successfully");
	}

}
