package com.mangaReview.webApp.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import jakarta.validation.*;

import java.util.Comparator;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String manga;
    @NotNull(message = "Username can not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Special Characters not allowed")
    private String name;
    private String rating;
    @NotNull(message = "Review field can not be empty")
    private String body;
}
