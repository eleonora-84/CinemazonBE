package com.cinemazon.cinemazon.repositories;

import com.cinemazon.cinemazon.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
