package com.cinemazon.cinemazon.repositories;

import com.cinemazon.cinemazon.entities.Auditorium;
import com.cinemazon.cinemazon.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
    public Optional<Auditorium> findAuditoriumByName(String name);

}
