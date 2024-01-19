package com.example.disney.model.specification;

import com.example.disney.model.Genero;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class GeneroSpecification {

    /*public static Specification<Genero> fieldLike(String field) {
        String formattedExpression = "%" + (StringUtils.hasLength(expression) ? expression.trim() : null) + "%";
        return (root, query, builder) -> builder.like(root.get(field), formattedExpression);
    }*/

    public static Specification<Genero> fieldLike(String field) {
            String formattedExpression = "%" + (StringUtils.hasLength(field) ? field.trim() : null) + "%";
            return (root, query, builder) -> builder.like(root.get(field), formattedExpression);
    }

}
