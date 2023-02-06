package com.degreeproject.IENP.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "subject")
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String subject;
    private String department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Subject(Long id, String subject, String department) {
        this.id = id;
        this.subject = subject;
        this.department = department;
    }
}
