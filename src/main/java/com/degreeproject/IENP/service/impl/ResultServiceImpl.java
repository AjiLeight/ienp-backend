package com.degreeproject.IENP.service.impl;

import com.degreeproject.IENP.entity.Result;
import com.degreeproject.IENP.repository.ResultRepository;
import com.degreeproject.IENP.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultRepository resultRepository;
    @Override
    public Result addResult(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public List<Result> getResultBySubjectAndMonthAndYear(String subject, String month, String year) {
        return resultRepository.findAllBySubjectAndMonthAndYear(subject,month,year);
    }

    @Override
    public List<Result> getResultByRollNoAndMonthAndYear(String rollNo, String month, String year) {
        return resultRepository.findAllByRollNoAndMonthAndYear(rollNo,month,year);

    }

    @Override
    public Result updateResult(Result result) {
        Result existingResult = resultRepository.findById(result.getId()).orElseThrow();
        existingResult.setSubject(result.getSubject());
        existingResult.setRollNo(result.getRollNo());
        existingResult.setMonth(result.getMonth());
        existingResult.setYear(result.getYear());
        existingResult.setMark(result.getMark());

        return resultRepository.save(existingResult);
    }

    @Override
    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteResultByStudent(String rollNo) {
        resultRepository.deleteAllByRollNo(rollNo);
    }


}
