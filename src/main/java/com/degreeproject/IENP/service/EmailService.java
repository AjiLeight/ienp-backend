package com.degreeproject.IENP.service;

import com.degreeproject.IENP.dto.AnnouncementDto;
import com.degreeproject.IENP.entity.EmailDetails;

public interface EmailService {
    void sendSimpleEmail(EmailDetails details);
    void sendBulkEmail(AnnouncementDto announcementDto);
}
