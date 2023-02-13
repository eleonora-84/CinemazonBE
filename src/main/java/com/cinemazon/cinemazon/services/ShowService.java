package com.cinemazon.cinemazon.services;

import com.cinemazon.cinemazon.entities.MovieShow;
import com.cinemazon.cinemazon.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    public List<MovieShow> findAllShows() {
        return showRepository.findAll();
    }

    public Optional<MovieShow> findShowById(long id) {
        return showRepository.findById(id);
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
