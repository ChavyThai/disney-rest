package com.example.disney.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity(name = "Peliculas")

public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String image;
    private String title;
    private LocalDate createdDate;
    private Integer calification;

    @ManyToMany (mappedBy = "peliculas", cascade = CascadeType.ALL)
    private List<Personaje> personajes =  new ArrayList<>();

    public void addPersonaje(Personaje personaje) {
        personajes.add(personaje);
        personaje.getPeliculas().add(this);
    }

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "peliculas_genero",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private List<Genero> generos = new ArrayList<>();

    public void addGenero(Genero genero) {
        generos.add(genero);
        genero.getPeliculas().add(this);
    }
}



