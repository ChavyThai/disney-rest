package com.example.disney.service;

import com.example.disney.dto.PersonajeDTO;
import com.example.disney.model.Personaje;
import com.example.disney.model.specification.PersonajeSpecification;
import com.example.disney.repository.PersonajeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Map;

@Service
public class PesonajeService {

    @Autowired
    PersonajeRepository personajeRepository;
    @Autowired
    private ModelMapper modelMapper;


    public List<Personaje> getAllPersonajes(){
        return personajeRepository.findAll();
    }

    public PersonajeDTO createPersonaje(PersonajeDTO personajeDTO) {
        Personaje personaje = modelMapper.map(personajeDTO, Personaje.class);
        personaje = personajeRepository.saveAndFlush(personaje);
        return modelMapper.map(personaje, PersonajeDTO.class);
    }

    public PersonajeDTO getPersonajeById(Integer personajeId){
        Personaje personaje = personajeRepository.findById(personajeId).orElseThrow();
        return modelMapper.map(personaje, PersonajeDTO.class);
    }

    public PersonajeDTO updatePersonaje(PersonajeDTO personaje, Integer personajeId){
       Personaje oldPersonaje = personajeRepository.findById(personajeId).orElseThrow();
       oldPersonaje.setImage(personaje.getImage());
       oldPersonaje.setName(personaje.getName());
       oldPersonaje.setDoB(personaje.getDoB());
       oldPersonaje.setWeight(personaje.getWeight());
       oldPersonaje.setHistory(personaje.getHistory());
       oldPersonaje = personajeRepository.saveAndFlush(oldPersonaje);
       return modelMapper.map(oldPersonaje, PersonajeDTO.class);
    }

    public void deletePersonajeById(Integer personajeId){
        personajeRepository.deleteById(personajeId);
    }

    public List<Personaje> findPersonajes(Map<String, String> queryMap) {
        Specification<Personaje> where = Specification
                .where(queryMap.containsKey("name") ? PersonajeSpecification.fieldLike("name", queryMap.get("name")) : null)
                .and(queryMap.containsKey("history") ? PersonajeSpecification.fieldLike("history", queryMap.get("history")) : null)
                .and(queryMap.containsKey("weight") ? PersonajeSpecification.numberEqual("weight", Integer.valueOf(queryMap.get("weight"))) : null)
                .and(queryMap.containsKey("movieName") ? PersonajeSpecification.peliculaNameLike(queryMap.get("movieName")) : null);
        return personajeRepository.findAll(where);
    }
}
