package com.example.disney.service;

import com.example.disney.dto.PeliculaDTO;
import com.example.disney.dto.PersonajeDTO;
import com.example.disney.model.Pelicula;
import com.example.disney.model.Personaje;
import com.example.disney.repository.PeliculaRepository;
import com.example.disney.repository.PersonajeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;
    @Autowired
    PersonajeRepository personajeRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Pelicula> getAllPeliculas(){
        return peliculaRepository.findAll();
    }

    public PeliculaDTO createPelicula(PeliculaDTO peliculaDTO) {
        Pelicula pelicula = modelMapper.map(peliculaDTO, Pelicula.class);
        pelicula = peliculaRepository.saveAndFlush(pelicula);
        return modelMapper.map(pelicula, PeliculaDTO.class);
    }

    public PeliculaDTO getPeliculaById(Integer peliculaId) {
        Pelicula pelicula = peliculaRepository.findById(peliculaId).orElseThrow();
        return modelMapper.map(pelicula, PeliculaDTO.class);
    }

    public PeliculaDTO updatePelicula(PeliculaDTO pelicula, Integer peliculaId) {
        Pelicula oldPelicula = peliculaRepository.findById(peliculaId).orElseThrow();
        oldPelicula.setImage(pelicula.getImage());
        oldPelicula.setTitle(pelicula.getTitle());
        oldPelicula.setCreatedDate(pelicula.getCreatedDate());
        oldPelicula.setCalification(pelicula.getCalification());
        oldPelicula = peliculaRepository.saveAndFlush(oldPelicula);
        return modelMapper.map(oldPelicula, PeliculaDTO.class);
    }

    public void deletePeliculaById(Integer peliculaId){
        peliculaRepository.deleteById(peliculaId);
    }


}
