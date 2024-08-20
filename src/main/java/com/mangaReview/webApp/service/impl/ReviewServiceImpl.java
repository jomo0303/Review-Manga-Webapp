package com.mangaReview.webApp.service.impl;

import com.mangaReview.webApp.Models.Review;
import com.mangaReview.webApp.Repositories.ReviewRepository;
import com.mangaReview.webApp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {


    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @Override
    public List<Review> findAllReview() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews;
    }

    @Override
    public List<Review> findReviewByManga(String manga) {
        List<Review> reviews = reviewRepository.findByManga(manga);
        return reviews;
    }

    @Override
    public Boolean reviewExists(String name, String manga) {
        return reviewRepository.existsByNameAndManga(name, manga);
    }

    @Override
    public void saveReview(Review review) {
        reviewRepository.save(review);
    }
}
