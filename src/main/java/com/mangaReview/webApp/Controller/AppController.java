package com.mangaReview.webApp.Controller;

import com.mangaReview.webApp.Models.Manga;
import com.mangaReview.webApp.Models.Review;
import com.mangaReview.webApp.service.MangaService;
import com.mangaReview.webApp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/manga")
public class AppController {


    private MangaService mangaService;
    private ReviewService reviewService;

    @Autowired
    public AppController(MangaService mangaService, ReviewService reviewService) {
        this.mangaService = mangaService;
        this.reviewService = reviewService;
    }
    @GetMapping("/list")
    public String listManga(Model model) {
        List<Manga> mangas = mangaService.findAllManga();
        model.addAttribute("mangas", mangas);
        return "mangaList";
    }
    @PostMapping("/submitReview")
    public String submitReview(@ModelAttribute("review") Review review){
        Manga manga = mangaService.findMangabyTitle(review.getManga());
        if(reviewService.reviewExists(review.getName(), review.getManga())){
            throw new RuntimeException("Review already exists");
        }
        reviewService.saveReview(review);
        List<Review> reviews = reviewService.findReviewByManga(review.getManga());
        int sum = 0;
        for (Review r : reviews) {
            sum += Integer.parseInt(r.getRating());
        }

        manga.setRating((float) sum / reviews.size());
        mangaService.updateManga(manga);
        return "redirect:/manga/" + manga.getId();
    }
    @GetMapping("/error")
    public String error(Model model) {
        List<Manga> mangas = mangaService.findAllManga();
        model.addAttribute("mangas", mangas);
        return "error";
    }
    @GetMapping("/1")
    public String onePiece(Model model) {
        List<Review> reviews = reviewService.findReviewByManga("One Piece");
        model.addAttribute("reviews", reviews);
        model.addAttribute("review", new Review());
        Manga manga = mangaService.findMangabyTitle("One Piece");
        model.addAttribute("man", manga);
        return "onePiece";
    }
    @GetMapping("/2")
    public String kingdom(Model model) {
        List<Review> reviews = reviewService.findReviewByManga("Kingdom");
        model.addAttribute("reviews", reviews);
        model.addAttribute("review", new Review());
        Manga manga = mangaService.findMangabyTitle("Kingdom");
        model.addAttribute("man", manga);
        return "kingdom";
    }

    @GetMapping("/6")
    public String dragonBall(Model model) {
        List<Review> reviews = reviewService.findReviewByManga("Dragon Ball Super");
        model.addAttribute("reviews", reviews);
        model.addAttribute("review", new Review());
        Manga manga = mangaService.findMangabyTitle("Dragon Ball Super");
        model.addAttribute("man", manga);
        return "dragonBallSuper";
    }
    @GetMapping("/7")
    public String naruto(Model model) {
        List<Review> reviews = reviewService.findReviewByManga("Naruto");
        model.addAttribute("reviews", reviews);
        model.addAttribute("review", new Review());
        Manga manga = mangaService.findMangabyTitle("Naruto");
        model.addAttribute("man", manga);
        return "naruto";
    }
    @GetMapping("/8")
    public String apothecary(Model model) {
        List<Review> reviews = reviewService.findReviewByManga("Apothecary Diaries");
        model.addAttribute("reviews", reviews);
        model.addAttribute("review", new Review());
        Manga manga = mangaService.findMangabyTitle("Apothecary Diaries");
        model.addAttribute("man", manga);
        return "apothecary";
    }
    @GetMapping("/9")
    public String yourName(Model model) {
        List<Review> reviews = reviewService.findReviewByManga("Your Name");
        model.addAttribute("reviews", reviews);
        model.addAttribute("review", new Review());
        Manga manga = mangaService.findMangabyTitle("Your Name");
        model.addAttribute("man", manga);
        return "yourName";
    }
    @GetMapping("/10")
    public String demonSlayer(Model model) {
        List<Review> reviews = reviewService.findReviewByManga("Demon Slayer");
        model.addAttribute("reviews", reviews);
        model.addAttribute("review", new Review());
        Manga manga = mangaService.findMangabyTitle("Demon Slayer");
        model.addAttribute("man", manga);
        return "demonSlayer";
    }
    @GetMapping("/11")
    public String aot(Model model) {
        List<Review> reviews = reviewService.findReviewByManga("Attack on Titan");
        model.addAttribute("reviews", reviews);
        model.addAttribute("review", new Review());
        Manga manga = mangaService.findMangabyTitle("Attack on Titan");
        model.addAttribute("man", manga);
        return "aot";
    }
    @GetMapping("/12")
    public String jjba(Model model) {
        List<Review> reviews = reviewService.findReviewByManga("JoJo's Bizzare Adventure");
        model.addAttribute("reviews", reviews);
        model.addAttribute("review", new Review());
        Manga manga = mangaService.findMangabyTitle("JoJo's Bizzare Adventure");
        model.addAttribute("man", manga);
        return "jjba";
    }
}
