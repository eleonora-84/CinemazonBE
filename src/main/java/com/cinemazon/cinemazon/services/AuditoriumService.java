package com.cinemazon.cinemazon.services;

import com.cinemazon.cinemazon.entities.Auditorium;
import com.cinemazon.cinemazon.repositories.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditoriumService {
    @Autowired
    private AuditoriumRepository auditoriumRepository;

    public List<Auditorium> findAllAuditoriums() {
        return auditoriumRepository.findAll();
    }

    public Optional<Auditorium> findAuditoriumById(long id) {
        return auditoriumRepository.findById(id);
    }
    public Optional<Auditorium> findAuditoriumByName(String name) {
        return auditoriumRepository.findAuditoriumByName(name);
    }

    public Auditorium createAuditorium(Auditorium newAuditorium) {
        return auditoriumRepository.save(newAuditorium);
    }

    public Auditorium updateAuditorium(Auditorium updatedAuditorium) {
        if (auditoriumRepository.findById(updatedAuditorium.getId()).isEmpty())
            return auditoriumRepository.save(updatedAuditorium);
        else {
            Auditorium oldAud = auditoriumRepository.findById(updatedAuditorium.getId()).get();
            oldAud.setName(updatedAuditorium.getName());
            oldAud.setNumSeats(updatedAuditorium.getNumSeats());
            oldAud.setSeat(updatedAuditorium.getSeat());
            return oldAud;
        }
    }

    public void deleteAuditoriumById(long id) {
        auditoriumRepository.deleteById(id);
    }

}
