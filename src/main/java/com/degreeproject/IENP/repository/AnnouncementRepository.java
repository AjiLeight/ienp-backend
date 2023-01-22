package com.degreeproject.IENP.repository;

import com.degreeproject.IENP.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    List<Announcement> findAllByFacultyIdOrderByDateDesc(String Id);
    List<Announcement> findAllByOrderByDateDesc();

}
