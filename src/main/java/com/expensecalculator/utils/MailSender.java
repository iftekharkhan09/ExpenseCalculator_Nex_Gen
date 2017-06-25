package com.expensecalculator.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailSender {
	@Autowired
	JavaMailSender mailServerConfig;
	public void sendMail() {
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		simpleMailMessage.setFrom("noreply@gmail.com");
		simpleMailMessage.setTo("iftekharkhan245@gmail.com");
		simpleMailMessage.setSubject("Test Mail");
		simpleMailMessage.setText("Hello Iftekhar!!");
		System.out.println("Mail Called");
		mailServerConfig.send(simpleMailMessage);
	}
}
