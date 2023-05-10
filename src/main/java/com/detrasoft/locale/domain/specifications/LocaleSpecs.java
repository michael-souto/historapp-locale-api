package com.detrasoft.locale.domain.specifications;

import com.detrasoft.locale.domain.entities.Locale;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

public class LocaleSpecs {

    public static Specification<Locale> byName(String name) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();
            if (name != null && !name.isBlank()) {
                predicates.add(
                        builder.like(
                                builder.upper(root.get("name").as(String.class)),
                                "%" + name.toUpperCase() + "%"));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };

    }

    public static Specification<Locale> byComments(String comments) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();
            if (comments != null && !comments.isBlank()) {
                predicates.add(
                        builder.like(
                                builder.upper(root.get("comments").as(String.class)),
                                "%" + comments.toUpperCase() + "%"));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };

    }

    public static Specification<Locale> byTag(String tag) {
        return (root, query, builder) -> {
            var predicates = new ArrayList<Predicate>();
            if (tag != null && !tag.isBlank()) {
                predicates.add(
                        builder.like(
                                builder.lower(root.get("tags").as(String.class)),
                                "%" + tag.toLowerCase() + "%"));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };

    }
}
