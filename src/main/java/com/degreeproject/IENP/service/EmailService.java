package com.degreeproject.IENP.service;

import com.degreeproject.IENP.entity.EmailDetails;

public interface EmailService {
    void sendSimpleEmail(EmailDetails details);
}
