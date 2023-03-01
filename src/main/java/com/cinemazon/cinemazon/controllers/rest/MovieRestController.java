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
    public ResponseEntity<List<Movie>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(), HttpStatus.OK);
    }
    @GetMapping("/all/sorted")
    public ResponseEntity<List<Movie>> findAllMoviesSorted(){
        return new ResponseEntity<>(movieService.findAllMoviesSorted(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> findMovieById(@PathVariable long id){
        if (movieService.findMovieById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        else{
            return new ResponseEntity<>(movieService.findMovieById(id).get(), HttpStatus.OK);
        }
    }
    @GetMapping("/")
    public ResponseEntity<Movie> findMovieByTitle(@RequestParam String title){
        if (movieService.findMovieByTitle(title).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        else{
            return new ResponseEntity<>(movieService.findMovieByTitle(title).get(), HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie newMovie){
        return new ResponseEntity<>(movieService.createMovie(newMovie), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie updatedMovie){
        return new ResponseEntity<>(movieService.updateMovie(updatedMovie), HttpStatus.OK);
    }

    @DeleteMapping("/deletebytitle")
    public ResponseEntity<String> deleteMovieByMovieTitle(@RequestParam String title){
        movieService.deleteMovieByTitle(title);
        return new ResponseEntity<>("Film " + title + " eliminato con successo", HttpStatus.OK);
    }

    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<String> deleteMovieById(@PathVariable long id){
        movieService.deleteById(id);
        return new ResponseEntity<>("Film con id " + id + " cancellato con successo", HttpStatus.OK);
    }
}
