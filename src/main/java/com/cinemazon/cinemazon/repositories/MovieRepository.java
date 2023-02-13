package com.cinemazon.cinemazon.repositories;

import com.cinemazon.cinemazon.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    public Optional<Movie> findMovieByTitle(String title);
}
