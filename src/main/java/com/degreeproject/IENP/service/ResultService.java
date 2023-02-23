package com.degreeproject.IENP.service;

import com.degreeproject.IENP.entity.Result;

import java.util.List;

public interface ResultService {
    Result addResult(Result result);
    List<Result> getResultBySubjectAndMonthAndYear(String subject, String month, String year);
    List<Result> getResultByRollNoAndMonthAndYear(String rollNo, String month, String year);
    Result updateResult(Result result);
    void deleteResult(Long id);
    void deleteResultByStudent(String rollNo);
}
