package com.degreeproject.IENP.service.impl;

import com.degreeproject.IENP.entity.EmailDetails;
import com.degreeproject.IENP.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") private String sender;
    @Async
    @Override
    public void sendSimpleEmail(EmailDetails details) {
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(details.getRecipient());
            simpleMailMessage.setText(details.getMessageBody());
            simpleMailMessage.setSubject(details.getSubject());

            javaMailSender.send(simpleMailMessage);
            System.out.println( "Mail Sent Successfully");
        }
        catch (Exception e){
            System.out.println( e.getMessage());
        }
    }
}
