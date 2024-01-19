package com.example.disney.controller;

import com.example.disney.model.Genero;
import com.example.disney.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/generos")

public class GeneroController {

    @Autowired
    GeneroService generoService;

    @GetMapping
    public List<Genero> getAllGeneros(@RequestParam (value = "genero", required = false) Optional<String> genero) {
        return generoService.findGenero(buildQueryMap(genero));
    }

    @PostMapping
    public Genero createGenero(@RequestBody Genero genero) {
        return generoService.createGenero(genero);
    }

    @GetMapping("/{generoId}")
    public Genero getGeneroById(@PathVariable Integer generoId) {
        return generoService.getGeneroById(generoId);
    }

    @PutMapping("/{generoId}")
    public Genero updateGeneroById(@PathVariable Integer generoId) {
        return generoService.updateGeneroById(generoId);
    }

    @DeleteMapping("/{generoId}")
    public void deleteGeneroById(@PathVariable Integer generoId) {
        generoService.deleteGeneroById(generoId);
    }

    private Map<String, String> buildQueryMap(Optional<String> oGenero) {
        Map<String, String> queryParams = new HashMap<>();
        oGenero.ifPresent(genero -> queryParams.put("genero", genero));
        return queryParams;
    }

}
