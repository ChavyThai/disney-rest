package com.example.disney.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "peliculas")

public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String image;
    private String title;
    private LocalDate createdDate;
    private Integer calification;

    @ManyToMany (mappedBy = "peliculas", cascade = CascadeType.ALL)
    private List<Personaje> personajes;

    public void addPersonaje(Personaje personaje){
        personajes.add(personaje);
    }


}
