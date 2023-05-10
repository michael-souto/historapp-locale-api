package com.detrasoft.locale.api.dtos;

import com.detrasoft.framework.api.controllers.jackson.ResponseView;
import com.detrasoft.framework.api.dto.GenericRepresentationModelDTO;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;

import javax.persistence.Column;
import java.time.Instant;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "locales")
public class LocaleDTO extends GenericRepresentationModelDTO<LocaleDTO> {

    @JsonView(ResponseView.findAndPersist.class)
    private Long id;

    @JsonView(ResponseView.findAndPersist.class)
    private String name;

    @JsonView(ResponseView.findAndPersist.class)
    private String comments;

    @JsonView(ResponseView.findAndPersist.class)
    private String tags;

    @JsonView(ResponseView.findAndPersist.class)
    private Long lat;

    @JsonView(ResponseView.findAndPersist.class)
    private Long lng;

    @JsonView(ResponseView.findAndPersist.class)
    private Long visibility;

    @JsonView({ ResponseView.post.class, ResponseView.find.class})
    private Instant createAt;

    @JsonView({ ResponseView.put.class, ResponseView.find.class})
    private Instant updateAt;
}
