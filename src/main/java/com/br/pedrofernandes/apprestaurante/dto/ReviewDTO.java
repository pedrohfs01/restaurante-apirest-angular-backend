package com.br.pedrofernandes.apprestaurante.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter @Setter
public class ReviewDTO {

    private String name;
    private Double rating;
    private String comments;
    private String restauranteId;
}
