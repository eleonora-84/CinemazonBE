package com.cinemazon.cinemazon.controllers.rest;


import com.cinemazon.cinemazon.entities.MovieShow;
import com.cinemazon.cinemazon.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalTime;
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

    @GetMapping("/all/sorted")
    public ResponseEntity<List<MovieShow>> findAllShowsSorted(){
        return new ResponseEntity<>(showService.findAllShowsSorted(), HttpStatus.OK);
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
    @GetMapping("/movie/")
     //TODO + @PATHVARIABLE bytitle/
    public ResponseEntity<List<MovieShow>> findShowByMovieTitle(@RequestParam(value = "movie") String title){
        return new ResponseEntity<>(showService.findShowsByMovieTitle(title), HttpStatus.OK);
    }

    @GetMapping("/titledaytime")
    public ResponseEntity<MovieShow> findShowByTitleAndDayAndTime(@RequestParam(value = "title", required = true) String title, @RequestParam(value = "day", required = true) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate day, @RequestParam(value = "time", required = true) @DateTimeFormat(pattern = "HH:mm") LocalTime time){
        if (showService.findShowByMovieTitleAndDayAndTime(title, day, time).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        else{
            return new ResponseEntity<>(showService.findShowByMovieTitleAndDayAndTime(title, day, time).get(), HttpStatus.OK);
        }
    }

    @GetMapping("/date")
    public ResponseEntity<List<MovieShow>> findShowByDay(@RequestParam(value = "day", required = true) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate day){
        if (showService.findShowByDay(day).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Giorno non valido");
        } else {
            return new ResponseEntity<>(showService.findShowByDay(day), HttpStatus.OK);
        }
    }
    @GetMapping("/time")
    public ResponseEntity<List<MovieShow>> findShowByTime(@RequestParam(value = "time", required = true) @DateTimeFormat(pattern = "HH:mm") LocalTime time){
        if (showService.findShowByTime(time).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Orario non valido");
        } else {
            return new ResponseEntity<>(showService.findShowByTime(time), HttpStatus.OK);
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

    @DeleteMapping("/deletebytitledaytime")
    public ResponseEntity<String> deleteShowByTitleAndDayAndTime(@RequestParam(value = "title", required = true) String title, @RequestParam(value = "day", required = true) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate day, @RequestParam(value = "time", required = true) @DateTimeFormat(pattern = "HH:mm") LocalTime time){
        if (showService.findShowByMovieTitleAndDayAndTime(title, day, time).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        else{
            showService.deleteShowByMovieTitleAndDayAndTime(title, day, time);
            return new ResponseEntity<>("Spettacolo cancellato con successo", HttpStatus.OK);
        }
    }
}
