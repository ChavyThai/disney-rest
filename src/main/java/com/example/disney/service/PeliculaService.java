package com.example.disney.service;

import com.example.disney.model.Genero;
import com.example.disney.model.Pelicula;
import com.example.disney.model.Personaje;
import com.example.disney.repository.PeliculaRepository;
import com.example.disney.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    public List<Pelicula> getAllPeliculas(){
        return peliculaRepository.findAll();
    }

    public Pelicula createPelicula(@RequestBody Pelicula pelicula) {
        return peliculaRepository.saveAndFlush(pelicula);
    }

    public Pelicula getPeliculaById(@PathVariable Integer peliculaId) {
        return peliculaRepository.findById(peliculaId).orElseThrow();
    }

    public Pelicula updatePelicula(@RequestBody Pelicula pelicula,
                                   @PathVariable Integer peliculaId) {
        Pelicula oldPelicula = peliculaRepository.findById(peliculaId).orElseThrow();
        oldPelicula.setImage(oldPelicula.getImage());
        oldPelicula.setTitle(oldPelicula.getTitle());
        oldPelicula.setDoc(oldPelicula.getDoc());
        oldPelicula.setCalification(oldPelicula.getCalification());
        oldPelicula.setPersonajes(oldPelicula.getPersonajes());
        return peliculaRepository.saveAndFlush(oldPelicula);
    }

    public void deletePeliculaById(@PathVariable Integer peliculaId){
        peliculaRepository.deleteById(peliculaId);
    }


}
