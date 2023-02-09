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
@RequestMapping("/api/show")
@CrossOrigin
public class ShowRestController {
    @Autowired
    private ShowService showService;

    @GetMapping("/all")
    private ResponseEntity<List<MovieShow>> findAllShows(){
        return new ResponseEntity<>(showService.findAllShows(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    private ResponseEntity<MovieShow> findShowById(@PathVariable long id){
        if (showService.findShowById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        else{
            return new ResponseEntity<>(showService.findShowById(id).get(), HttpStatus.OK);
        }
    }

    @PostMapping("/")
    private ResponseEntity<MovieShow> createShow(@RequestBody MovieShow newShow){
        return new ResponseEntity<>(showService.createShow(newShow), HttpStatus.CREATED);
    }

    @PutMapping("/")
    private ResponseEntity<MovieShow> updateShow(@RequestBody MovieShow updatedShow){
        return new ResponseEntity<>(showService.updateShow(updatedShow), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteShowById(@PathVariable long id){
        showService.deleteShowById(id);
        return new ResponseEntity<>("Spettacolo eliminato con successo", HttpStatus.OK);
    }
}
