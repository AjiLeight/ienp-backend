package com.degreeproject.IENP.dto;

import lombok.Data;

@Data
public class StudentDto {
    private Long rollNo;
    private String name;
    private String department;
    private String year;

    public StudentDto(Long rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }
}
