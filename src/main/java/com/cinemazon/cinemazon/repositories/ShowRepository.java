package com.cinemazon.cinemazon.repositories;

import com.cinemazon.cinemazon.entities.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<MovieShow, Long> {
}
