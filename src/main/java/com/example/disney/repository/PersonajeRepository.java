package com.example.disney.repository;

import com.example.disney.model.Personaje;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PersonajeRepository extends JpaRepository<Personaje, Integer>, JpaSpecificationExecutor<Personaje> {

}
