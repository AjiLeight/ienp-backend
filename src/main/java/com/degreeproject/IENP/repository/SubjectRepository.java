package com.degreeproject.IENP.repository;

import com.degreeproject.IENP.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findAllByDepartment(String department);
}
