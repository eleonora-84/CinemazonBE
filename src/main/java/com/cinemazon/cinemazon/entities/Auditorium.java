package com.cinemazon.cinemazon.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private String name;
    @NotNull
    @Min(1)
    private int numSeats;

    @ElementCollection
    @Column(name = "seat")
    @Size(max = 150)
    private List<String> seat;

    public Auditorium(String name, int numSeats, List<String> seat) {
        this.name = name;
        this.numSeats = numSeats;
        this.seat = seat;
    }
}
