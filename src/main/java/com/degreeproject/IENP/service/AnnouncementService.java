package com.degreeproject.IENP.service;

import com.degreeproject.IENP.entity.Announcement;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AnnouncementService {

    public Announcement addAnnouncement(Announcement announcement);
    public Announcement updateAnnouncement(Announcement announcement);
    public Announcement getAnnouncementById(Long Id);
    public List<Announcement> getAnnouncement();
    public List<Announcement> getAnnouncementByFacultyIdOrdered(String id);
    public void deleteAnnouncement(Long id);
    public Boolean existById(Long id);

}
