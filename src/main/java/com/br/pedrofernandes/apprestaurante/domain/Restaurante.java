package com.br.pedrofernandes.apprestaurante.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter @EqualsAndHashCode
@Entity
public class Restaurante {

    @Id
    private String id;
    private String name;
    private String category;
    private String deliveryEstimate;
    private Double rating;
    private String imagePath;
    private String about;
    private String hours;

    public Restaurante(){
    }

    public Restaurante(String id, String name, String category, String deliveryEstimate, Double rating, String imagePath, String about, String hours) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.deliveryEstimate = deliveryEstimate;
        this.rating = rating;
        this.imagePath = imagePath;
        this.about = about;
        this.hours = hours;
    }


}