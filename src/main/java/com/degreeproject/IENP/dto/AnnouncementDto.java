package com.degreeproject.IENP.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AnnouncementDto {
    private String title;
    private String subject;
    private String description;
    private Long facultyId;

    public AnnouncementDto(String title, String subject, String description, Long facultyId) {
        this.title = title;
        this.subject = subject;
        this.description = description;
        this.facultyId = facultyId;
    }
}
