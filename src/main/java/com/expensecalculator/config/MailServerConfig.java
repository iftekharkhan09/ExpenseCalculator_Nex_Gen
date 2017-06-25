package com.expensecalculator.config;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailServerConfig {
	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost("smtp.gmail.com");
		javaMailSenderImpl.setPort(587);
		javaMailSenderImpl.setJavaMailProperties(getMailProperties());
		javaMailSenderImpl.setUsername("iftekharkhan629@gmail.com");
		javaMailSenderImpl.setPassword("Sunny@310591");
		return javaMailSenderImpl;
	}
	private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "false");
        properties.setProperty("mail.smtp.starttls.enable", "false");
        properties.setProperty("mail.debug", "false");
        return properties;
    }
}
