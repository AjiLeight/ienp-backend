package com.degreeproject.IENP.service.impl;

<<<<<<< Updated upstream
public class FacultyServiceImpl {
=======
import com.degreeproject.IENP.entity.Faculty;
import com.degreeproject.IENP.repository.FacultyRepository;
import com.degreeproject.IENP.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService {
    private FacultyRepository facultyRepository;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    @Override
    public Faculty getFaculty(String username) {
        return facultyRepository.findById(username).orElseThrow();
    }
>>>>>>> Stashed changes
}
