package com.mangaReview.webApp.Controller;

import com.mangaReview.webApp.Models.Manga;
import com.mangaReview.webApp.Models.Review;
import com.mangaReview.webApp.service.MangaService;
import com.mangaReview.webApp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ExceptionController implements ErrorController {
    private MangaService mangaService;
    private ReviewService reviewService;

    @Autowired
    public ExceptionController(MangaService mangaService, ReviewService reviewService) {
        this.mangaService = mangaService;
        this.reviewService = reviewService;
    }

    @RequestMapping("/error")
    public String error(Model model) {
        List<Manga> mangas = mangaService.findAllManga();
        model.addAttribute("mangas", mangas);
        return "error";
    }
}
