package com.degreeproject.IENP.controller;

import com.degreeproject.IENP.entity.Faculty;
import com.degreeproject.IENP.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/faculty")
@RequiredArgsConstructor
public class FacultyController {
    private final FacultyService facultyService;

    @GetMapping("{username}")
    public Faculty getFaculty(@PathVariable String username){
        return facultyService.getFaculty(username);
    }
}
