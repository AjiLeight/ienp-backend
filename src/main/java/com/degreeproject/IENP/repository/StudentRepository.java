package com.degreeproject.IENP.repository;

import com.degreeproject.IENP.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findAllByDepartmentContains(String department);
    Student findByRollNo(String rollNo);
    List<Student> findAllByDepartmentAndYear(String department, String year);

}
