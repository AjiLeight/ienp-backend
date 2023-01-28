package com.degreeproject.IENP.service;

import com.degreeproject.IENP.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudentByDepartment(String department);
    Student getStudentByRollNo(String rollNo);
    Student addStudent(Student student);
    List<Student> getStudentByDepartmentAndYear(String department, String year);
    void deleteStudent(String rollNo);
    Student updateStudent(Student student);
    Student promoteStudent(String rollNo);

}
