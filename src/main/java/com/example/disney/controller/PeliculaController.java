package com.example.disney.controller;

import com.example.disney.dto.PeliculaDTO;

import com.example.disney.model.Pelicula;
import com.example.disney.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/peliculas")

public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> getPeliculaList(@RequestParam(value = "name", required = false) Optional<String> name,
                                          @RequestParam(value = "calification", required = false) Optional<Integer> calification,
                                          @RequestParam(value = "personajeName", required = false) Optional<String> personajeName) {
        return peliculaService.findPeliculas(buildQueryMap(name, calification, personajeName));
    }


    @PostMapping
    public PeliculaDTO createPelicula(@RequestBody PeliculaDTO pelicula) {
        return peliculaService.createPelicula(pelicula);
    }

    @GetMapping("/{peliculaId}")
    public PeliculaDTO getPeliculaById(@PathVariable Integer peliculaId) {
        return peliculaService.getPeliculaById(peliculaId);
    }

    @PutMapping("/{peliculaId}")
    public PeliculaDTO updatePelicula(@RequestBody PeliculaDTO pelicula,
                                      @PathVariable Integer peliculaId) {
        return peliculaService.updatePelicula(pelicula, peliculaId);
    }

    @DeleteMapping("/{peliculaId}")
    public void deletePeliculaById(@PathVariable Integer peliculaId) {
        peliculaService.deletePeliculaById(peliculaId);
    }

    private Map<String, String> buildQueryMap(Optional<String> oName, Optional<Integer> oCalification, Optional<String> oPersonajeName){
        Map<String, String> queryParams = new HashMap<>();
        oName.ifPresent(name -> queryParams.put("name", name));
        oCalification.ifPresent(calification -> queryParams.put("Calification", String.valueOf(calification)));
        oPersonajeName.ifPresent(personajeName -> queryParams.put("personajeName", personajeName));
        return queryParams;
    }
}
