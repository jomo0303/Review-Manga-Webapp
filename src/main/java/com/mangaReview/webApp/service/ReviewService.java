package com.mangaReview.webApp.service;

import com.mangaReview.webApp.Models.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAllReview();
    List<Review> findReviewByManga(String manga);
    Boolean reviewExists(String name, String manga);
    void saveReview(Review review);
}
