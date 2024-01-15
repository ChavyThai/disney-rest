package com.example.disney.model.specification;

import com.example.disney.model.Personaje;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public final class PersonajeSpecification {

    public static Specification<Personaje> fieldLike(String field, String expression) {
        String formattedExpression = "%" + (StringUtils.hasLength(expression) ? expression.trim() : null) + "%";
        return (root, query, builder) -> builder.like(root.get(field), formattedExpression);
    }

    public static Specification<Personaje> numberEqual(String field, Integer expression){
        return (root, query, builder) -> builder.equal(root.get(field), expression);
    }

    public static Specification<Personaje> peliculaNameLike(String peliculaName) {
        String formattedExpression = "%" + (StringUtils.hasLength(peliculaName) ? peliculaName.trim() : null) + "%";
        return (root, query, builder) -> builder.like(root.join("peliculas").get("title"), formattedExpression);
    }
}
