package com.degreeproject.IENP.service.impl;

import com.degreeproject.IENP.entity.Student;
import com.degreeproject.IENP.repository.StudentRepository;
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
    @Override
    public List<Student> getStudentByDepartment(String department) {
        return studentRepository.findAllByDepartmentContains(department);
    }

    @Override
    public Student getStudentByRollNo(Long rollNo) {
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
    public void deleteStudent(Long rollNo) {
        studentRepository.deleteById(rollNo);
    }

    @Override
    public Student updateStudent(Student student) {
        Student existingStudent = studentRepository.findByRollNo(student.getRollNo());
        existingStudent.setRollNo(student.getRollNo());
        existingStudent.setName(student.getName());

        return studentRepository.save(existingStudent);
    }
}
