package com.example.disney.controller;

import com.example.disney.model.Genero;
import com.example.disney.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/generos")

public class GeneroController {

    @Autowired
    GeneroService generoService;

    @GetMapping
    public List<Genero> getAllGeneros() {
        return generoService.getAllGeneros();
    }

    @PostMapping
    public Genero createGenero(@RequestBody Genero genero){
        return generoService.createGenero(genero);
    }

    @GetMapping("/{generoId}")
    public Genero getGeneroById(@PathVariable Integer generoId){
        return generoService.getGeneroById(generoId);
    }

    @PutMapping("/{generoId}")
    public Genero updateGeneroById (@RequestBody Genero genero,
                                    @PathVariable Integer generoId){
        return generoService.updateGeneroById(genero, generoId);
    }

    @DeleteMapping("/{generoId}")
    public void deleteGeneroById(@PathVariable Integer generoId){
        generoService.deleteGeneroById(generoId);
    }

}
