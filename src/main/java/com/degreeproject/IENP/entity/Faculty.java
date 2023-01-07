package com.degreeproject.IENP.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "faculty")
@Data
@NoArgsConstructor
public class Faculty {
    @Id
    private String username;
    private String name;
    private String department;
}
