package com.degreeproject.IENP.controller;

import com.degreeproject.IENP.dto.SubjectDto;
import com.degreeproject.IENP.entity.Subject;
import com.degreeproject.IENP.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/subject")
@CrossOrigin
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("{department}")
    public ResponseEntity<List<String>> getSubjects(@PathVariable String department){
        return ResponseEntity.ok(subjectService.getSubjectsByDept(department));
    }

    @PostMapping()
    public ResponseEntity<Subject> addSubject(@RequestBody SubjectDto subjectDto){
        Subject subject = new Subject();
        subject.setSubject(subjectDto.getSubject());
        subject.setDepartment(subjectDto.getDepartment());

        return ResponseEntity.ok(subjectService.addSubject(subject));
    }

}
