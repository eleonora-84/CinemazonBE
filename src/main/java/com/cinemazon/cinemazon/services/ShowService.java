package com.cinemazon.cinemazon.services;

import com.cinemazon.cinemazon.entities.MovieShow;
import com.cinemazon.cinemazon.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    public List<MovieShow> findAllShows() {
        return showRepository.findAll((Sort.by(Sort.Direction.ASC, "day")).and(Sort.by(Sort.Direction.ASC, "time")));
    }

    public Optional<MovieShow> findShowById(long id) {
        return showRepository.findById(id);
    }

    public List<MovieShow> findShowsByMovieTitle(String title){
        return showRepository.findByMovieTitle(title);
    }

    public Optional<MovieShow> findShowByMovieTitleAndDayAndTime(String title, LocalDate day, LocalTime time){
        return showRepository.findShowByMovieTitleAndDayAndTime(title, day, time);
    }

    public  List<MovieShow> findShowByDay(LocalDate day){
        return showRepository.findByDay(day);
    }

    public List<MovieShow> findShowByTime(LocalTime time){
        return showRepository.findByTime(time);
    }

    public MovieShow createShow(MovieShow newMovieShow) {
        return showRepository.save(newMovieShow);
    }

    public MovieShow updateShow(MovieShow updatedMovieShow) {
        if (showRepository.findById(updatedMovieShow.getId()).isEmpty())
            return showRepository.save(updatedMovieShow);
        else {
            MovieShow oldMovieShow = showRepository.findById(updatedMovieShow.getId()).get();
            oldMovieShow.setDay(updatedMovieShow.getDay());
            oldMovieShow.setTime(updatedMovieShow.getTime());
            oldMovieShow.setMovie(updatedMovieShow.getMovie());
            oldMovieShow.setAuditorium(updatedMovieShow.getAuditorium());
            return oldMovieShow;
        }
    }

    public void deleteShowById(long id) {
        showRepository.deleteById(id);
    }

}
