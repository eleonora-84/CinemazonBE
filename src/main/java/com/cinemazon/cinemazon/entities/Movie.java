package com.cinemazon.cinemazon.entities;

import com.cinemazon.cinemazon.entities.enums.Rating;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

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
    private boolean isOV;
    private String moviePoster;
    @Value("#{T(enums.Rating).PERTUTTI}")
    private Rating rating;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MovieShow> show = new ArrayList<>();


    public Movie(String title, String director, int duration, String plot, boolean isThreeD, boolean isFourK, boolean isDolby, boolean isOV, String moviePoster, Rating rating) {
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.plot = plot;
        this.isThreeD = isThreeD;
        this.isFourK = isFourK;
        this.isDolby = isDolby;
        this.isOV = isOV;
        this.moviePoster = moviePoster;
        this.rating = rating;
    }
}
