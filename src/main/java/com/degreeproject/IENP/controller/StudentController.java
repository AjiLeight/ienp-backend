package com.degreeproject.IENP.controller;

import com.degreeproject.IENP.dto.StudentDto;
import com.degreeproject.IENP.entity.Student;
import com.degreeproject.IENP.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id){
        return ResponseEntity.ok(studentService.getStudentByRollNo(id));
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<Student>> getStudentByDepartment(@PathVariable String department){
        return new ResponseEntity<>(studentService.getStudentByDepartment(department), HttpStatus.OK);
    }

    @GetMapping("/year/{department}/{year}")
    public ResponseEntity<List<Student>> getStudentByDepartmentAndYear(@PathVariable String department, @PathVariable String year){
        return new ResponseEntity<>(studentService.getStudentByDepartmentAndYear(department, year), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody StudentDto studentDto){
        Student student = new Student();
        student.setRollNo(studentDto.getRollNo());
        student.setName(studentDto.getName());
        student.setDepartment(studentDto.getDepartment());
        student.setYear(studentDto.getYear());

        return new ResponseEntity<>(studentService.addStudent(student),HttpStatus.OK);
    }

    @DeleteMapping("{rollNo}")
    public ResponseEntity<String> deleteStudent(@PathVariable String rollNo){
        studentService.deleteStudent(rollNo);
        return ResponseEntity.ok("Deleted "+ rollNo);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody StudentDto studentDto){
        Student student = new Student();
        student.setRollNo(studentDto.getRollNo());
        student.setName(studentDto.getName());

        return ResponseEntity.ok(studentService.updateStudent(student));
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteStudent(@RequestBody List<String> rollNoList){
        rollNoList.forEach(rollNo -> {
            studentService.deleteStudent(rollNo);
        });
        return ResponseEntity.ok("Deleted");
    }

    @PutMapping("increase")
    public ResponseEntity<String> promoteStudent(@RequestBody List<String> rollNoList) {
        rollNoList.forEach(rollNo -> {
            studentService.promoteStudent(rollNo);
        });
        return ResponseEntity.ok("promoted");
    }

}
