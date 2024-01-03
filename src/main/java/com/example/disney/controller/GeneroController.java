package com.example.disney.controller;

import com.example.disney.dto.GeneroDTO;
import com.example.disney.model.Genero;
import com.example.disney.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public GeneroDTO createGenero(@RequestBody GeneroDTO genero){
        return generoService.createGenero(genero);
    }

    @GetMapping("/{generoId}")
    public GeneroDTO getGeneroById(@PathVariable Integer generoId){
        return generoService.getGeneroById(generoId);
    }

    @PutMapping("/{generoId}")
    public GeneroDTO updateGeneroById (@RequestBody GeneroDTO genero,
                                    @PathVariable Integer generoId){
        return generoService.updateGeneroById(genero, generoId);
    }

    @DeleteMapping("/{generoId}")
    public void deleteGeneroById(@PathVariable Integer generoId){
        generoService.deleteGeneroById(generoId);
    }

}
