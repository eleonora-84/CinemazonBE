package com.cinemazon.cinemazon.services;

import com.cinemazon.cinemazon.entities.Auditorium;
import com.cinemazon.cinemazon.entities.Movie;
import com.cinemazon.cinemazon.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public List<Movie> findAllMoviesSorted() {
        return movieRepository.findAll((Sort.by(Sort.Direction.ASC, "title")));
    }
    public Optional<Movie> findMovieById(long id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> findMovieByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
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
            oldMovie.setPlot(updatedMovie.getPlot());
            oldMovie.setThreeD(updatedMovie.isThreeD());
            oldMovie.setFourK(updatedMovie.isFourK());
            oldMovie.setOV(updatedMovie.isOV());
            oldMovie.setDolby(updatedMovie.isDolby());
            oldMovie.setVM14(updatedMovie.isVM14());
            oldMovie.setMoviePoster(updatedMovie.getMoviePoster());
            return oldMovie;
        }
    }

    public void deleteMovieByTitle(String title) {
        movieRepository.deleteByTitle(title);
    }
    public void deleteById(long id){

        movieRepository.deleteById(id);
    }

}
