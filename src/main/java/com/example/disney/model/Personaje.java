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
@Entity(name = "personajes")

public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String image;
    private String name;
    private LocalDate doB;
    private Integer weight;
    private String history;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "personaje_peliculas",
                joinColumns = @JoinColumn(name = "pelicula_id"),
                inverseJoinColumns = @JoinColumn(name = "personaje_id")
    )
    private List<Pelicula> peliculas;

    public void addPelicula (Pelicula pelicula){
        peliculas.add(pelicula);
    }
}
