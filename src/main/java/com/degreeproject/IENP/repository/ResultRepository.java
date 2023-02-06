package com.degreeproject.IENP.repository;

import com.degreeproject.IENP.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findAllBySubjectAndMonthAndYear(String subject, String month, String year);
    List<Result> findAllByRollNoAndMonthAndYear(String rollNo, String month, String year);

}
