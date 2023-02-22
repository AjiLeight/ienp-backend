package com.degreeproject.IENP.service.impl;

import com.degreeproject.IENP.entity.NewsLetter;
import com.degreeproject.IENP.repository.NewsLetterRepository;
import com.degreeproject.IENP.service.NewsLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsLetterServiceImpl implements NewsLetterService {
    @Autowired
    private NewsLetterRepository newsLetterRepository;

    @Override
    public NewsLetter saveEmail(String email) {
        NewsLetter newsLetter = new NewsLetter();
        newsLetter.setEmail(email);
        return newsLetterRepository.save(newsLetter);
    }
}
