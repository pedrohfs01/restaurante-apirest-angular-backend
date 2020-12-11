package com.br.pedrofernandes.apprestaurante.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter @EqualsAndHashCode
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date date;

    private Double rating;
    private String comments;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    @JsonIgnore
    private Restaurante restaurante;

    public Review(){}

    public Review(String name, Double rating, String comments) {
        this.name = name;
        this.rating = rating;
        this.comments = comments;
    }
}
