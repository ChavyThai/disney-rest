package com.example.disney.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class GeneroDTO {

        private Integer Id;
        private Integer genero;

        private List<GeneroDTO> generos = new ArrayList<>();
}

