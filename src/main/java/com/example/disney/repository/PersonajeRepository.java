package com.example.disney.repository;

import com.example.disney.model.Personaje;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



public interface PersonajeRepository extends JpaRepository<Personaje, Integer>, JpaSpecificationExecutor<Personaje> {

}
