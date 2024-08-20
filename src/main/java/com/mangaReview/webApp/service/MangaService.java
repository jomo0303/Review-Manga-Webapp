package com.mangaReview.webApp.service;

import com.mangaReview.webApp.Models.Manga;
import com.mangaReview.webApp.Models.Review;

import java.util.List;

public interface MangaService {
    List<Manga> findAllManga();
    Manga findMangabyTitle(String title);
    void updateManga(Manga manga);
}
