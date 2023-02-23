package com.degreeproject.IENP.service.impl;

import com.degreeproject.IENP.entity.Student;
import com.degreeproject.IENP.repository.StudentRepository;
import com.degreeproject.IENP.service.ResultService;
import com.degreeproject.IENP.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private ResultService resultService;
    @Override
    public List<Student> getStudentByDepartment(String department) {
        return studentRepository.findAllByDepartmentContains(department);
    }

    @Override
    public Student getStudentByRollNo(String rollNo) {
        return studentRepository.findByRollNo(rollNo);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentByDepartmentAndYear(String department, String year) {
        return studentRepository.findAllByDepartmentAndYear(department, year);
    }

    @Override
    public void deleteStudent(String rollNo) {
        resultService.deleteResultByStudent(rollNo);
        studentRepository.deleteById(rollNo);
    }

    @Override
    public Student updateStudent(Student student) {
        Student existingStudent = studentRepository.findByRollNo(student.getRollNo());
        existingStudent.setRollNo(student.getRollNo());
        existingStudent.setName(student.getName());

        return studentRepository.save(existingStudent);
    }

    @Override
    public Student promoteStudent(String rollNo) {
        Student student = studentRepository.findByRollNo(rollNo);
        student.setYear(Integer.toString(Integer.parseInt(student.getYear())+1));
        return studentRepository.save(student);
    }
}
