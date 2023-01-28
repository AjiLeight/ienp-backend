package com.degreeproject.IENP.dto;

import lombok.Data;

@Data
public class StudentDto {
    private String rollNo;
    private String name;
    private String department;
    private String year;

    public StudentDto(String rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }
}
