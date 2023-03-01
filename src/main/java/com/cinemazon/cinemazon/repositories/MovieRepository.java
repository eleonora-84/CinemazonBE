package com.cinemazon.cinemazon.repositories;

import com.cinemazon.cinemazon.entities.Movie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    public Optional<Movie> findMovieByTitle(String title);

    @Transactional
    @Modifying
    public void deleteByTitle (String title);

}
