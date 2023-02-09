package com.cinemazon.cinemazon.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private int numSeats;

    private boolean is3D;
    private boolean is4K;
    private boolean isDolby;

    public Auditorium(String name, int numSeats, boolean is3D, boolean is4K, boolean isDolby) {
        this.name = name;
        this.numSeats = numSeats;
        this.is3D = is3D;
        this.is4K = is4K;
        this.isDolby = isDolby;
    }
}
