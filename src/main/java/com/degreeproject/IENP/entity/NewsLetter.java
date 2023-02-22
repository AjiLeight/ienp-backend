package com.degreeproject.IENP.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "newsletter")
@Data
@NoArgsConstructor
public class NewsLetter {
    @Id
    private String email;
}
