package com.degreeproject.IENP.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AnnouncementDto {
    private String title;
    private String subject;
    private String description;
    private String facultyId;

    public AnnouncementDto(String title, String subject, String description, String facultyId) {
        this.title = title;
        this.subject = subject;
        this.description = description;
        this.facultyId = facultyId;
    }
}
