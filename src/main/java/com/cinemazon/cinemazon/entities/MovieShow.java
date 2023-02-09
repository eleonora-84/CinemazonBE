package com.cinemazon.cinemazon.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // @NotEmpty TODO ?!
    @JsonFormat(pattern = "dd-MM-YYYY")
    private LocalDate day;
    // @NotEmpty TODO ?!
    @JsonFormat(pattern = "HH:mm")
    private LocalTime time;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Auditorium auditorium;

    public MovieShow(LocalDate day, LocalTime time, Movie movie, Auditorium auditorium) {
        this.day = day;
        this.time = time;
        this.movie = movie;
        this.auditorium = auditorium;
    }
}
