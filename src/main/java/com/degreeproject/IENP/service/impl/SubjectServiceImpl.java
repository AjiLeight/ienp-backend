package com.degreeproject.IENP.service.impl;

import com.degreeproject.IENP.entity.Subject;
import com.degreeproject.IENP.repository.SubjectRepository;
import com.degreeproject.IENP.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject getSubject(Long id) {
        return subjectRepository.findById(id).orElseThrow();
    }

    @Override
    public List<String> getSubjectsByDept(String department) {
        List<Subject> subjectList =  subjectRepository.findAllByDepartment(department);
        List<String> subjects = new ArrayList<>();
        subjectList.forEach(subject -> {subjects.add(subject.getSubject());});
        return subjects;
    }
}
