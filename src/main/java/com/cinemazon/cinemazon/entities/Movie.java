package com.cinemazon.cinemazon.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
// TODO Aggiungere anno film
// TODO Aggiungere locandina film
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
    // @NotEmpty TODO va bene per le stringhe ma non per int?
    private int duration;

    private boolean is3D;

    private boolean is4K;

    private boolean isDolby;

    private boolean isVM14;

    private boolean isVM18;

    private boolean isOV;

    public Movie(String title, String director, int duration, boolean is3D, boolean is4K, boolean isDolby, boolean isVM14, boolean isVM18, boolean isOV) {
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.is3D = is3D;
        this.is4K = is4K;
        this.isDolby = isDolby;
        this.isVM14 = isVM14;
        this.isVM18 = isVM18;
        this.isOV = isOV;
    }
}
