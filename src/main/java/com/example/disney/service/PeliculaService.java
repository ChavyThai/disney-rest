package com.example.disney.service;

import com.example.disney.model.Pelicula;
import com.example.disney.model.Personaje;
import com.example.disney.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    public List<Pelicula> getAllPeliculas(){
        return peliculaRepository.findAll();
    }

    public Pelicula createPelicula(Pelicula pelicula) {
        return peliculaRepository.saveAndFlush(pelicula);
    }

    public Pelicula getPeliculaById(Integer peliculaId) {
        return peliculaRepository.findById(peliculaId).orElseThrow();
    }

    public Pelicula updatePelicula(Pelicula pelicula, Integer peliculaId) {
        Pelicula oldPelicula = peliculaRepository.findById(peliculaId).orElseThrow();
        oldPelicula.setImage(pelicula.getImage());
        oldPelicula.setTitle(pelicula.getTitle());
        oldPelicula.setCreatedDate(pelicula.getCreatedDate());
        oldPelicula.setCalification(pelicula.getCalification());
        oldPelicula.setPersonajes(pelicula.getPersonajes());
        return peliculaRepository.saveAndFlush(oldPelicula);
    }

    public void deletePeliculaById(Integer peliculaId){
        peliculaRepository.deleteById(peliculaId);
    }


    public Pelicula addPersonaje (Integer peliculaId, Personaje personaje){
        Pelicula pelicula = peliculaRepository.findById(peliculaId).orElseThrow();
        pelicula.addPersonaje(personaje);
        pelicula = peliculaRepository.saveAndFlush(pelicula);
        return pelicula;
    }

}
