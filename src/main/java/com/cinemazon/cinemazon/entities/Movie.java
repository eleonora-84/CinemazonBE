package com.cinemazon.cinemazon.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
// TODO Aggiungere anno film
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String director;
    @NotNull
    @Min(1)
    private int duration;

    @NotEmpty
    private String plot;

    private boolean isThreeD;

    private boolean isFourK;

    private boolean isDolby;

    private boolean isVM14;

    private boolean isVM18;

    private boolean isOV;
    private String moviePoster;

    public Movie(String title, String director, int duration, String plot, boolean isThreeD, boolean isFourK, boolean isDolby, boolean isVM14, boolean isVM18, boolean isOV, String moviePoster) {
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.plot = plot;
        this.isThreeD = isThreeD;
        this.isFourK = isFourK;
        this.isDolby = isDolby;
        this.isVM14 = isVM14;
        this.isVM18 = isVM18;
        this.isOV = isOV;
        this.moviePoster = moviePoster;
    }
}
