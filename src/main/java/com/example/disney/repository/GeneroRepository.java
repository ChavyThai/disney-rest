package com.example.disney.repository;

import com.example.disney.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GeneroRepository extends JpaRepository<Genero, Integer>, JpaSpecificationExecutor<Genero> {
}
