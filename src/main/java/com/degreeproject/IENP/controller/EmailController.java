package com.degreeproject.IENP.controller;

import com.degreeproject.IENP.entity.EmailDetails;
import com.degreeproject.IENP.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mail")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping()
    public ResponseEntity<String> sendMail(@RequestBody EmailDetails emailDetails){
        emailService.sendSimpleEmail(emailDetails);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
