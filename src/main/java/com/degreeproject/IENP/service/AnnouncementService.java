package com.degreeproject.IENP.service;

import com.degreeproject.IENP.entity.Announcement;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AnnouncementService {

    public Announcement addAnnouncement(Announcement announcement);
    public List<Announcement> getAnnouncement();
    public void deleteAnnouncement(Long id);

    public Boolean existById(Long id);

}
