package com.degreeproject.IENP.controller;

import com.degreeproject.IENP.dto.ResultDto;
import com.degreeproject.IENP.entity.Result;
import com.degreeproject.IENP.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/results")
@CrossOrigin
@RequiredArgsConstructor
public class ResultController {
    private final ResultService resultService;
    @PostMapping
    public ResponseEntity<Result> addResult(@RequestBody ResultDto resultDto){
        Result result = new Result();
        result.setRollNo(resultDto.getRollNo());
        result.setMonth(resultDto.getMonth());
        result.setYear(resultDto.getYear());
        result.setSubject(resultDto.getSubject());
        result.setMark(resultDto.getMark());
        return new ResponseEntity<>(resultService.addResult(result), HttpStatus.OK);
    }

    @GetMapping("/subject/{subject}/{month}/{year}")
    public ResponseEntity<List<Result>> getResultBySubject(@PathVariable String subject, @PathVariable String month, @PathVariable String year ){
        return new ResponseEntity<>(resultService.getResultBySubjectAndMonthAndYear(
                subject,
                month,
                year),HttpStatus.OK);
    }

    @GetMapping("/rollno/{rollNo}/{month}/{year}")
    public ResponseEntity<List<Result>> getResultRollNo(@PathVariable String rollNo, @PathVariable String month, @PathVariable String year  ){
        return new ResponseEntity<>(resultService.getResultByRollNoAndMonthAndYear(
                rollNo,
                month,
                year),HttpStatus.OK);
    }
}
