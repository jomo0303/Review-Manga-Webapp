package com.mangaReview.webApp.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Manga")
public class Manga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String imageSrc;
    private float rating;
    private String author;

    public float getRating() {
        DecimalFormat df = new DecimalFormat("#.##");
        rating = Float.parseFloat(df.format(rating));
        return rating;
    }
}
