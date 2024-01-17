package com.example.disney.model.specification;

import com.example.disney.model.Pelicula;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public final class PeliculaSpecification {

    public static Specification<Pelicula> fieldLike(String field, String expression){
        String formattedExpression = "%" + (StringUtils.hasLength(expression) ? expression.trim() : null) + "%";
        return (root, query, builder) -> builder.like(root.get(field), formattedExpression);
    }

    public static Specification<Pelicula> numberEqual(String field, Integer expression){
        return (root, query, builder) -> builder.equal(root.get(field), expression);
    }

    public static Specification<Pelicula> personajeNameLike(String personajeName) {
        String formattedExpression = "%" + (StringUtils.hasLength(personajeName) ? personajeName.trim() : null) + "%";
        return (root, query, builder) -> builder.like(root.join("personajes").get("name"), formattedExpression);
    }
}

