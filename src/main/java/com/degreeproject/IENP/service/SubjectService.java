package com.degreeproject.IENP.service;

import com.degreeproject.IENP.entity.Subject;

import java.util.List;

public interface SubjectService {
    Subject addSubject(Subject subject);
    Subject getSubject(Long id);
    List<String> getSubjectsByDept(String department);
}
