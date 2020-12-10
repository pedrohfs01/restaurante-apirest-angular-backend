package com.br.pedrofernandes.apprestaurante.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter @Setter
public class ReviewDTO {
    private Long id;
    private String name;
    private Instant date;
    private Double rating;
    private String comments;
    private String restauranteId;
}
