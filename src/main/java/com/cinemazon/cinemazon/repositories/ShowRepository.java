package com.cinemazon.cinemazon.repositories;

import com.cinemazon.cinemazon.entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
}
