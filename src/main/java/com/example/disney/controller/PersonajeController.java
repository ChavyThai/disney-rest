package com.example.disney.controller;

import com.example.disney.dto.PersonajeDTO;
import com.example.disney.model.Pelicula;
import com.example.disney.model.Personaje;
import com.example.disney.service.PesonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personajes")

public class PersonajeController {

    @Autowired
    PesonajeService personajeService;


    @GetMapping
    public List<Personaje> getAllpersonajes(){
        return personajeService.getAllPersonajes();
    }

    @PostMapping
    public PersonajeDTO createPersonaje(@RequestBody PersonajeDTO personaje){
        return personajeService.createPersonaje(personaje);
    }

    @GetMapping("/{personajeId}")
    public PersonajeDTO getPersonajeById(@PathVariable Integer personajeId){
        return personajeService.getPersonajeById(personajeId);
    }

    @PutMapping("/{personajeId}")
    public PersonajeDTO updatePersonaje(@RequestBody PersonajeDTO personaje,
                                     @PathVariable Integer personajeId){
       return personajeService.updatePersonaje(personaje, personajeId);
    }

    @DeleteMapping("/{personajeId}")
    public void deletePersonajeById(@PathVariable Integer personajeId){
        personajeService.deletePersonajeById(personajeId);
    }


}
