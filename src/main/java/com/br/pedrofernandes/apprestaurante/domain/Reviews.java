package com.br.pedrofernandes.apprestaurante.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Entity
public class Reviews {

    @Id
    private Long id;
    private String name;
    private Instant date;
    private Double rating;
    private String comments;

    @ManyToOne
    private Restaurante restauranteId;

}
