package com.example.disney.controller;

import com.example.disney.model.Personaje;
import com.example.disney.service.PesonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;

import java.util.List;
import java.util.Map;

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
    public Personaje createPersonaje(@RequestBody Personaje personaje){
        return personajeService.createPersonaje(personaje);
    }

    @GetMapping("/{personajeId}")
    public Personaje getPersonajeById(@PathVariable Integer personajeId){
        return personajeService.getPersonajeById(personajeId);
    }

    @PutMapping("/{personajeId}")
    public Personaje updatePersonaje(@RequestBody Personaje personaje,
                                     @PathVariable Integer personajeId){
       return personajeService.updatePersonaje(personaje, personajeId);
    }

    @DeleteMapping("/{personajeId}")
    public void deletePersonajeById(@PathVariable Integer personajeId){
        personajeService.deletePersonajeById(personajeId);
    }


}
