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

    public MovieShow createShow(MovieShow newShow) {
        return showRepository.save(newShow);
    }

    public MovieShow updateShow(MovieShow updatedShow) {
        if (showRepository.findById(updatedShow.getId()).isEmpty())
            return showRepository.save(updatedShow);
        else {
            MovieShow oldShow = showRepository.findById(updatedShow.getId()).get();
            oldShow.setDay(updatedShow.getDay());
            oldShow.setTime(updatedShow.getTime());
            oldShow.setMovie(updatedShow.getMovie());
            oldShow.setAuditorium(updatedShow.getAuditorium());
            return oldShow;
        }
    }

    public void deleteShowById(long id) {
        showRepository.deleteById(id);
    }

}
