package com.degreeproject.IENP.repository;

<<<<<<< Updated upstream
public class StudentRepository {
=======
import com.degreeproject.IENP.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByDepartmentContains(String department);
    Student findByRollNo(Long rollNo);
    List<Student> findAllByDepartmentAndYear(String department, String year);

>>>>>>> Stashed changes
}
