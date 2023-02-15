package com.cinemazon.cinemazon;

import com.cinemazon.cinemazon.entities.Auditorium;
import com.cinemazon.cinemazon.entities.Movie;
import com.cinemazon.cinemazon.entities.MovieShow;
import com.cinemazon.cinemazon.services.AuditoriumService;
import com.cinemazon.cinemazon.services.MovieService;
import com.cinemazon.cinemazon.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
@CrossOrigin
public class DataLoadRunner implements CommandLineRunner {
    @Autowired
    private AuditoriumService auditoriumService;
    @Autowired
    private ShowService showService;
    @Autowired
    private MovieService movieService;
    @Override
    public void run(String... args) throws Exception {
        Auditorium a1 = new Auditorium("Sala 1", 150, false, true, true);
        Auditorium a2 = new Auditorium("Sala 2", 100, true, true, true);
        auditoriumService.createAuditorium(a1);
        auditoriumService.createAuditorium(a2);

        Movie m1 = new Movie("Everything Everywhere all at once", "Daniels", 140, false, false, false, false, false, true, "https://tinyurl.com/2k98tpkj");
        Movie m2 = new Movie("Cena con delitto - Knives out", "Rian Johnson", 130, false, true, true, false, false, true, "https://tinyurl.com/46x92y32");
        Movie m3 = new Movie("Avatar - La via dell'acqua", "James Cameron", 192, true, true, true, false, false, true, "https://tinyurl.com/mr3bv2m8");
        Movie m4 = new Movie("Shining - Remastered", "Stanley Kubrick", 144, false, true, true, true, false, true, "https://tinyurl.com/yrvf3n7x");
        movieService.createMovie(m1);
        movieService.createMovie(m2);
        movieService.createMovie(m3);
        movieService.createMovie(m4)

        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 02), LocalTime.of(20,30), m1, a1));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 02), LocalTime.of(20,00), m2, a2));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 03), LocalTime.of(19,30), m3, a1));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 03), LocalTime.of(21,30), m1, a2));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 03), LocalTime.of(23,30), m1, a1));

        System.out.println("Application started");
    }
}
