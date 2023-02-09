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
            oldAud.set3D(updatedAuditorium.is3D());
            oldAud.set4K(updatedAuditorium.is4K());
            oldAud.setDolby(updatedAuditorium.isDolby());
            return oldAud;
        }
    }

    public void deleteAuditoriumById(long id) {
        auditoriumRepository.deleteById(id);
    }

}
