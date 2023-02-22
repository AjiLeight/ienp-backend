package com.degreeproject.IENP.service;

import com.degreeproject.IENP.entity.NewsLetter;

import java.util.List;

public interface NewsLetterService {
    NewsLetter saveEmail(String email);
    List<NewsLetter> getAllEmails();
}
