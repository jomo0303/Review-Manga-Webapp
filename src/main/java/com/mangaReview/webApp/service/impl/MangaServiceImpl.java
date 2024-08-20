package com.mangaReview.webApp.service.impl;

import com.mangaReview.webApp.Models.Manga;
import com.mangaReview.webApp.Models.Review;
import com.mangaReview.webApp.Repositories.MangaRepository;
import com.mangaReview.webApp.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaServiceImpl implements MangaService {

    private MangaRepository mangaRepository;

    @Autowired
    public MangaServiceImpl(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }

    @Override
    public List<Manga> findAllManga() {
        List<Manga> mangas = mangaRepository.findAll();
        return mangas;
    }

    @Override
    public Manga findMangabyTitle(String title) {
        Manga manga = mangaRepository.findByTitle(title);
        return manga;
    }

    @Override
    public void updateManga(Manga manga) {
        mangaRepository.save(manga);
    }
}
