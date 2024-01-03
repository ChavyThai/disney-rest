package com.example.disney.controller;

import com.example.disney.dto.PeliculaDTO;
import com.example.disney.dto.PersonajeDTO;
import com.example.disney.model.Pelicula;
import com.example.disney.model.Personaje;
import com.example.disney.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")

public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> getAllpeliculas() {
        return peliculaService.getAllPeliculas();
    }


    @PostMapping
    public PeliculaDTO createPelicula(@RequestBody PeliculaDTO pelicula) {
        return peliculaService.createPelicula(pelicula);
    }

    @GetMapping("/{peliculaId}")
    public PeliculaDTO getPeliculaById(@PathVariable Integer peliculaId) {
        return peliculaService.getPeliculaById(peliculaId);
    }

    @PutMapping("/{peliculaId}")
    public PeliculaDTO updatePelicula(@RequestBody PeliculaDTO pelicula,
                                    @PathVariable Integer peliculaId) {
        return peliculaService.updatePelicula(pelicula, peliculaId);
    }

    @DeleteMapping("/{peliculaId}")
    public void deletePeliculaById(@PathVariable Integer peliculaId){
        peliculaService.deletePeliculaById(peliculaId);
    }


}
