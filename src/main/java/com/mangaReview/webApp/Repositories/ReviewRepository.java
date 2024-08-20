package com.mangaReview.webApp.Repositories;

import com.mangaReview.webApp.Models.Manga;
import com.mangaReview.webApp.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByManga(String manga);
    Boolean existsByNameAndManga(String name, String manga);
}
