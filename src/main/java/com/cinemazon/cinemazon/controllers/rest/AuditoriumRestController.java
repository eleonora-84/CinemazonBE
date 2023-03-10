package com.cinemazon.cinemazon.controllers.rest;

import com.cinemazon.cinemazon.entities.Auditorium;
import com.cinemazon.cinemazon.services.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/auditoriums")
@CrossOrigin
public class AuditoriumRestController {
    @Autowired
    AuditoriumService auditoriumService;

    @GetMapping("/all")
    public ResponseEntity<List<Auditorium>> findAllAuditoriums(){
        return new ResponseEntity<>(auditoriumService.findAllAuditoriums(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Auditorium> findAuditoriumById(@PathVariable long id){
        if (auditoriumService.findAuditoriumById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        else{
            return new ResponseEntity<>(auditoriumService.findAuditoriumById(id).get(), HttpStatus.OK);
        }
    }

    @GetMapping("/byname/")
    public ResponseEntity<Auditorium> findAuditoriumByName(@RequestParam(value = "name") String name){
        return new ResponseEntity<>(auditoriumService.findAuditoriumByName(name).get(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Auditorium> createAuditorium(@RequestBody Auditorium newAuditorium){
        return new ResponseEntity<>(auditoriumService.createAuditorium(newAuditorium), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Auditorium> updateAuditorium(@RequestBody Auditorium updatedAuditorium){
        return new ResponseEntity<>(auditoriumService.updateAuditorium(updatedAuditorium), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuditoriumById(@PathVariable long id){
        auditoriumService.deleteAuditoriumById(id);
        return new ResponseEntity<>("Sala eliminata con successo", HttpStatus.OK);
    }
}
