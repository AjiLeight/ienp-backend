package com.degreeproject.IENP.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
public class Student {
    @Id
    @Column(nullable = false)
    private String rollNo;
    @Column(nullable = false)

    private String name;
    @Column(nullable = false)

    private String department;
    @Column(nullable = false)

    private String year;
}
