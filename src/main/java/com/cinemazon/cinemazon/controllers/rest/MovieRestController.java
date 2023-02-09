package com.cinemazon.cinemazon.controllers.rest;


import com.cinemazon.cinemazon.entities.Movie;
import com.cinemazon.cinemazon.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin
public class MovieRestController {
    @Autowired
    MovieService movieService;

    @GetMapping("/all")
    private ResponseEntity<List<Movie>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    private ResponseEntity<Movie> findMovieById(@PathVariable long id){
        if (movieService.findMovieById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        else{
            return new ResponseEntity<>(movieService.findMovieById(id).get(), HttpStatus.OK);
        }
    }

    @PostMapping("/")
    private ResponseEntity<Movie> createMovie(@RequestBody Movie newMovie){
        return new ResponseEntity<>(movieService.createMovie(newMovie), HttpStatus.CREATED);
    }

    @PutMapping("/")
    private ResponseEntity<Movie> updateMovie(@RequestBody Movie updatedMovie){
        return new ResponseEntity<>(movieService.updateMovie(updatedMovie), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteMovieById(@PathVariable long id){
        movieService.deleteMovieById(id);
        return new ResponseEntity<>("Film eliminato con successo", HttpStatus.OK);
    }
}
