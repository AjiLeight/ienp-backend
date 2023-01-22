package com.degreeproject.IENP.controller;

import com.degreeproject.IENP.dto.AnnouncementDto;
import com.degreeproject.IENP.entity.Announcement;
import com.degreeproject.IENP.repository.AnnouncementRepository;
import com.degreeproject.IENP.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/announcement")
public class AnnouncementController {

    private AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService
                                  ) {
        this.announcementService = announcementService;
    }

    @PostMapping
    private ResponseEntity<Announcement> addAnnouncemet(@RequestBody AnnouncementDto announcementDto){

        Announcement announcement = new Announcement();
        announcement.setTitle(announcementDto.getTitle());
        announcement.setSubject(announcementDto.getSubject());
        announcement.setDescription(announcementDto.getDescription());
        announcement.setDate(new Date());
        announcement.setFacultyId(announcementDto.getFacultyId());

        return new ResponseEntity<>( announcementService.addAnnouncement(announcement) , HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<Announcement>> getAnnouncement(){
        return new ResponseEntity<>(announcementService.getAnnouncement(), HttpStatus.OK);

    }
    @GetMapping("/{id}")
    private ResponseEntity<List<Announcement>> getAnnouncementByFacultyId(@PathVariable("id") String id){
        return new ResponseEntity<>(announcementService.getAnnouncementByFacultyIdOrdered(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteAnnouncement(@PathVariable("id") Long id){
        if (!announcementService.existById(id)){
            return new ResponseEntity<>("no such announcement", HttpStatus.BAD_REQUEST);
        }
        announcementService.deleteAnnouncement(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAnnouncement(@PathVariable("id") Long id, @RequestBody AnnouncementDto announcement){
        if(!announcementService.existById(id)){
            return new ResponseEntity<>("no such announcement", HttpStatus.BAD_REQUEST);
        }
        Announcement exisitingAnnouncement = announcementService.getAnnouncementById(id);
        exisitingAnnouncement.setTitle(announcement.getTitle());
        exisitingAnnouncement.setSubject(announcement.getTitle());
        exisitingAnnouncement.setDescription(announcement.getDescription());
        exisitingAnnouncement.setFacultyId(announcement.getFacultyId());
        exisitingAnnouncement.setDate(new Date());

        announcementService.updateAnnouncement(exisitingAnnouncement);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);

    }
}
