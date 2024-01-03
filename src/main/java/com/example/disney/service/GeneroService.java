package com.example.disney.service;

import com.example.disney.dto.GeneroDTO;
import com.example.disney.model.Genero;
import com.example.disney.repository.GeneroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class GeneroService {

    @Autowired
    GeneroRepository generoRepository;
    @Autowired
    private ModelMapper modelMapper;


    public List<Genero> getAllGeneros(){
        return generoRepository.findAll();
    }

    public GeneroDTO createGenero(@RequestBody GeneroDTO generoDTO){
        Genero genero = modelMapper.map(generoDTO, Genero.class);
        genero = generoRepository.saveAndFlush(genero);
        return modelMapper.map(genero, GeneroDTO.class);
    }

    public GeneroDTO getGeneroById(@PathVariable Integer generoId){
        Genero genero = generoRepository.findById(generoId).orElseThrow();
        return modelMapper.map(genero, GeneroDTO.class);
    }

    public GeneroDTO updateGeneroById (@RequestBody GeneroDTO genero,
                                    @PathVariable Integer generoId) {
        Genero oldGenero = generoRepository.findById(generoId).orElseThrow();
        oldGenero.setName(oldGenero.getName());
        oldGenero.setImage(oldGenero.getImage());
        oldGenero = generoRepository.saveAndFlush(oldGenero);
        return modelMapper.map(oldGenero, GeneroDTO.class);
    }

    public void deleteGeneroById(@PathVariable Integer generoId){
        generoRepository.deleteById(generoId);
    }

}
