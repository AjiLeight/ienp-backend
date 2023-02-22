package com.degreeproject.IENP.controller;

import com.degreeproject.IENP.dto.NewsLetterDto;
import com.degreeproject.IENP.entity.NewsLetter;
import com.degreeproject.IENP.service.NewsLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/newsletter")
@CrossOrigin
public class NewsLetterController {
    @Autowired
    private NewsLetterService newsLetterService;
    @PostMapping()
    public ResponseEntity<NewsLetter> saveNewsLetter(@RequestBody NewsLetterDto newsLetterDto){
        return new ResponseEntity<>(newsLetterService.saveEmail(newsLetterDto.getEmail()), HttpStatus.OK);
    }
}
