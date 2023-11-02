package com.example.disney.service;

import com.example.disney.model.Personaje;
import com.example.disney.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Map;

@Service
public class PesonajeService {

    @Autowired
    PersonajeRepository personajeRepository;

    public List<Personaje> getAllPersonajes(){
        return personajeRepository.findAll();
    }

    public Personaje createPersonaje(@RequestBody Personaje personaje) {
        return personajeRepository.saveAndFlush(personaje);
    }

    public Personaje getPersonajeById(@PathVariable Integer personajeId){
        return personajeRepository.findById(personajeId).orElseThrow();
    }

    public Personaje updatePersonaje(@RequestBody Personaje personaje,
                                     @PathVariable Integer personajeId){
       Personaje oldPersonaje = personajeRepository.findById(personajeId).orElseThrow();
       oldPersonaje.setImage(personaje.getImage());
       oldPersonaje.setName(personaje.getName());
       oldPersonaje.setAge(personaje.getAge());
       oldPersonaje.setWeight(personaje.getWeight());
       oldPersonaje.setHistory(personaje.getHistory());
       return personajeRepository.saveAndFlush(oldPersonaje);
    }

    public void deletePersonajeById(@PathVariable Integer personajeId){
        personajeRepository.deleteById(personajeId);
    }

}
