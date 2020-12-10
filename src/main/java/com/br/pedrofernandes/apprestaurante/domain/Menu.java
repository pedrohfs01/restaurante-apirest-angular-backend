package com.br.pedrofernandes.apprestaurante.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter @Setter @EqualsAndHashCode
@Entity
public class Menu {

    @Id
    private String id;
    private String name;
    private String imagePath;
    private String description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
}
