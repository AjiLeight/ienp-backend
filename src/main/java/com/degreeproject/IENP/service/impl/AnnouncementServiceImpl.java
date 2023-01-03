package com.degreeproject.IENP.service.impl;

import com.degreeproject.IENP.entity.Announcement;
import com.degreeproject.IENP.repository.AnnouncementRepository;
import com.degreeproject.IENP.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private AnnouncementRepository announcementRepository;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }



    @Override
    public Announcement addAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    @Override
    public List<Announcement> getAnnouncement() {
        return announcementRepository.findAll();
    }

    @Override
    public void deleteAnnouncement(Long id) {
        announcementRepository.deleteById(id);
    }

    @Override
    public Boolean existById(Long id) {
        return announcementRepository.existsById(id);
    }
}
