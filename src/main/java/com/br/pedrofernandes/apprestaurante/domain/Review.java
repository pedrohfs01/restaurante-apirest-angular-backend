package com.br.pedrofernandes.apprestaurante.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Getter @Setter @EqualsAndHashCode
@Entity
public class Review {

    @Id
    private Long id;
    private String name;
    private Instant date;
    private Double rating;
    private String comments;

    @ManyToOne
    private Restaurante restauranteId;

}
