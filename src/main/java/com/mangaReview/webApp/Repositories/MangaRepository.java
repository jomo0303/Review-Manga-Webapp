package com.mangaReview.webApp.Repositories;

import com.mangaReview.webApp.Models.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MangaRepository extends JpaRepository<Manga, Long> {
    Manga findByTitle(String title);
}
