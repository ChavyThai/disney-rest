package com.example.disney.dto;

import jakarta.persistence.*;
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


public class PeliculaDTO {


    private Integer id;
    private String image;
    private String title;
    private LocalDate createdDate;
    private Integer calification;


    private List<PersonajeDTO> personajes =  new ArrayList<>();



}



