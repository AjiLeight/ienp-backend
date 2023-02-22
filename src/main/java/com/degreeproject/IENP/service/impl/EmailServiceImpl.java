package com.degreeproject.IENP.service.impl;

import com.degreeproject.IENP.dto.AnnouncementDto;
import com.degreeproject.IENP.entity.EmailDetails;
import com.degreeproject.IENP.entity.NewsLetter;
import com.degreeproject.IENP.service.EmailService;
import com.degreeproject.IENP.service.NewsLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private NewsLetterService newsLetterService;

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

    @Async
    @Override
    public void sendBulkEmail(AnnouncementDto announcementDto) {
        List<NewsLetter> emailList = newsLetterService.getAllEmails();
        emailList.forEach(email -> {
            EmailDetails emailDetails = new EmailDetails();
            emailDetails.setSubject(announcementDto.getSubject());
            emailDetails.setRecipient(email.getEmail());
            emailDetails.setMessageBody(announcementDto.getTitle() + "\n\n" + announcementDto.getDescription() + "\n\n Thanks and Regards \n XYZ University");
            sendSimpleEmail(emailDetails);
        });
    }
}
