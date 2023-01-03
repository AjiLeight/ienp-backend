package com.degreeproject.IENP.repository;

import com.degreeproject.IENP.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
