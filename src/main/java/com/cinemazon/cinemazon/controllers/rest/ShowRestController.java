package com.cinemazon.cinemazon.controllers.rest;


import com.cinemazon.cinemazon.entities.MovieShow;
import com.cinemazon.cinemazon.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
@CrossOrigin
public class ShowRestController {
    @Autowired
    private ShowService showService;

    @GetMapping("/all")
    public ResponseEntity<List<MovieShow>> findAllShows(){
        return new ResponseEntity<>(showService.findAllShows(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieShow> findShowById(@PathVariable long id){
        if (showService.findShowById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        else{
            return new ResponseEntity<>(showService.findShowById(id).get(), HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<MovieShow> createShow(@RequestBody MovieShow newMovieShow){
        return new ResponseEntity<>(showService.createShow(newMovieShow), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<MovieShow> updateShow(@RequestBody MovieShow updatedMovieShow){
        return new ResponseEntity<>(showService.updateShow(updatedMovieShow), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShowById(@PathVariable long id){
        showService.deleteShowById(id);
        return new ResponseEntity<>("Spettacolo eliminato con successo", HttpStatus.OK);
    }
}
