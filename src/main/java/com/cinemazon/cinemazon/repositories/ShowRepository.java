package com.cinemazon.cinemazon.repositories;

import com.cinemazon.cinemazon.entities.MovieShow;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface ShowRepository extends JpaRepository<MovieShow, Long> {
    public List<MovieShow> findByMovieTitle(String title);
    // @Query("SELECT s FROM MovieShow s WHERE s.movie.title = :title AND s.day = :day AND s.time = :time" ) @Param("time")
    public Optional<MovieShow> findShowByMovieTitleAndDayAndTime(String title, LocalDate day, LocalTime time);

    public List<MovieShow> findByDay(LocalDate day);
    public List<MovieShow> findByTime(LocalTime time);

    @Transactional
    @Modifying
    public void deleteShowByMovieTitleAndDayAndTime(String title, LocalDate day, LocalTime time);


}
