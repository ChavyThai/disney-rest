package com.example.disney.model.specification;

import com.example.disney.model.Personaje;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public final class PersonajeSpecification {

    public static Specification<Personaje> fieldLike(String field, String expression) {
        String formattedExpression = "%" + (StringUtils.hasLength(expression) ? expression.trim() : null) + "%";
        return (root, query, builder) -> builder.like(root.get(field), formattedExpression);
    }
}
