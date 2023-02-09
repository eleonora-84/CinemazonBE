package com.cinemazon.cinemazon.services;

import com.cinemazon.cinemazon.entities.Auditorium;
import com.cinemazon.cinemazon.entities.Movie;
import com.cinemazon.cinemazon.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findMovieById(long id) {
        return movieRepository.findById(id);
    }

    public Movie createMovie(Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    public Movie updateMovie(Movie updatedMovie) {
        if (movieRepository.findById(updatedMovie.getId()).isEmpty())
            return movieRepository.save(updatedMovie);
        else {
            Movie oldMovie = movieRepository.findById(updatedMovie.getId()).get();
            oldMovie.setTitle(updatedMovie.getTitle());
            oldMovie.setDirector(updatedMovie.getDirector());
            oldMovie.setDuration(updatedMovie.getDuration());
            oldMovie.set3D(updatedMovie.is3D());
            oldMovie.set4K(updatedMovie.is4K());
            oldMovie.setOV(updatedMovie.isOV());
            oldMovie.setDolby(updatedMovie.isDolby());
            oldMovie.setVM14(updatedMovie.isVM14());
            oldMovie.setVM18(updatedMovie.isVM18());
            return oldMovie;
        }
    }

    public void deleteMovieById(long id) {
        movieRepository.deleteById(id);
    }

}
