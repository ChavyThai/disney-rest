package com.example.disney.model;

import com.example.disney.dto.GeneroDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Genero")

public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Integer genero;

    @JsonIgnore
    @ManyToMany(mappedBy = "generos", cascade = CascadeType.ALL)
    private List<Pelicula> peliculas = new ArrayList<>();

    public void addPelicula (Pelicula pelicula){
        peliculas.add(pelicula);
    }

}
