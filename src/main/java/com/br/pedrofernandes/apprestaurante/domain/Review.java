package com.br.pedrofernandes.apprestaurante.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    public Review(){}

    public Review(Long id, String name, Instant date, Double rating, String comments) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.rating = rating;
        this.comments = comments;
    }
}
