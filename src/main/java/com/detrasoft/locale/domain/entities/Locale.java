package com.detrasoft.locale.domain.entities;

import com.detrasoft.framework.crud.entities.GenericEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "locale")
public class Locale  extends GenericEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String comments;

    @Column(nullable = true)
    private String tags;

    @Column(nullable = true)
    private Long lat;

    @Column(nullable = true)
    private Long lng;

    @Column(nullable = true)
    private Long visibility;

    @Column(nullable = false, updatable = false)
    private Instant createAt;

    @Column(nullable = true)
    private Instant updateAt;
}
