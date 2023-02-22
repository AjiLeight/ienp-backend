package com.degreeproject.IENP.repository;

import com.degreeproject.IENP.entity.NewsLetter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsLetterRepository extends JpaRepository<NewsLetter, String> {
}
