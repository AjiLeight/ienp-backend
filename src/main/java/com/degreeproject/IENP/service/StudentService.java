package com.degreeproject.IENP.service;

<<<<<<< Updated upstream
public class StudentService {
=======
import com.degreeproject.IENP.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudentByDepartment(String department);
    Student getStudentByRollNo(Long rollNo);
    Student addStudent(Student student);
    List<Student> getStudentByDepartmentAndYear(String department, String year);
    void deleteStudent(Long rollNo);
    Student updateStudent(Student student);

>>>>>>> Stashed changes
}
