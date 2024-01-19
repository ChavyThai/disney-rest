package com.example.disney.service;


import com.example.disney.model.Genero;
import com.example.disney.model.specification.GeneroSpecification;
import com.example.disney.repository.GeneroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;


@Service
public class GeneroService {

    @Autowired
    GeneroRepository generoRepository;
    @Autowired
    private ModelMapper modelMapper;


    public List<Genero> getAllGeneros() {
        return generoRepository.findAll();
    }

    public Genero createGenero(@RequestBody Genero generos) {
        Genero genero = modelMapper.map(generos, Genero.class);
        genero = generoRepository.saveAndFlush(genero);
        return modelMapper.map(genero, Genero.class);
    }

    public Genero getGeneroById(@PathVariable Integer generoId) {
        Genero genero = generoRepository.findById(generoId).orElseThrow();
        return modelMapper.map(genero, Genero.class);
    }

    public Genero updateGeneroById(@PathVariable Integer generoId) {
        Genero oldGenero = generoRepository.findById(generoId).orElseThrow();
        oldGenero.setGenero(oldGenero.getGenero());
        oldGenero = generoRepository.saveAndFlush(oldGenero);
        return modelMapper.map(oldGenero, Genero.class);
    }

    public void deleteGeneroById(@PathVariable Integer generoId) {
        generoRepository.deleteById(generoId);
    }

    /*public List<Genero> findGenero(Map<String, String> queryMap){
        Specification<Genero> where = Specification
                .where(queryMap.containsKey("category") ? GeneroSpecification.fieldLike("category", queryMap.get("category")) : null);
        return GeneroRepository.all;
    }*/

    /*public List<Genero> findGenero(String queryMap) {
        Specification<Genero> specification = Specification.where(
                queryMap.contains("genero") ? GeneroSpecification.fieldLike("genero") : null);
        return generoRepository.findAll(specification);
    }

     */

    public List<Genero> findGenero(Map<String, String> queryMap) {
        Specification<Genero> specification = Specification.where(
                queryMap != null && queryMap.containsKey("genero") ? GeneroSpecification.fieldLike("genero") : null);
        return generoRepository.findAll(specification);
    }


}
