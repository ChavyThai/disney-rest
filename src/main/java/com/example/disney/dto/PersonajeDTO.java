package com.example.disney.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonajeDTO {


    private Integer id;
    private String image;
    private String name;
    private LocalDate doB;
    private Integer weight;
    private String history;
    private List<PeliculaDTO> peliculas = new ArrayList<>();


}
