package com.cinemazon.cinemazon.services;

import com.cinemazon.cinemazon.entities.Show;
import com.cinemazon.cinemazon.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    public List<Show> findAllShows() {
        return showRepository.findAll();
    }

    public Optional<Show> findShowById(long id) {
        return showRepository.findById(id);
    }

    public Show createShow(Show newShow) {
        return showRepository.save(newShow);
    }

    public Show updateShow(Show updatedShow) {
        if (showRepository.findById(updatedShow.getId()).isEmpty())
            return showRepository.save(updatedShow);
        else {
            Show oldShow = showRepository.findById(updatedShow.getId()).get();
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
