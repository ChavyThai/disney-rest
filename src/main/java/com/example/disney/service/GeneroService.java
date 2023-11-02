package com.example.disney.service;

import com.example.disney.model.Genero;
import com.example.disney.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class GeneroService {

    @Autowired
    GeneroRepository generoRepository;


    public List<Genero> getAllGeneros(){
        return generoRepository.findAll();
    }

    public Genero createGenero(@RequestBody Genero genero){
        return generoRepository.saveAndFlush(genero);
    }

    public Genero getGeneroById(@PathVariable Integer generoId){
        return generoRepository.findById(generoId).orElseThrow();
    }

    public Genero updateGeneroById (@RequestBody Genero genero,
                                    @PathVariable Integer generoId) {
        Genero oldGenero = generoRepository.findById(generoId).orElseThrow();
        oldGenero.setName(oldGenero.getName());
        oldGenero.setImage(oldGenero.getImage());
        return generoRepository.saveAndFlush(oldGenero);
    }

    public void deleteGeneroById(@PathVariable Integer generoId){
        generoRepository.deleteById(generoId);
    }

}
