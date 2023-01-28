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

    @GetMapping("/subject")
    public ResponseEntity<List<Result>> getResultBySubject(@RequestBody ResultDto resultDto ){
        return new ResponseEntity<>(resultService.getResultBySubjectAndMonthAndYear(
                resultDto.getSubject(),
                resultDto.getMonth(),
                resultDto.getYear()),HttpStatus.OK);
    }

    @GetMapping("/rollno")
    public ResponseEntity<List<Result>> getResultRollNo(@RequestBody ResultDto resultDto ){
        return new ResponseEntity<>(resultService.getResultByRollNoAndMonthAndYear(
                resultDto.getRollNo(),
                resultDto.getMonth(),
                resultDto.getYear()),HttpStatus.OK);
    }
}
