package com.br.pedrofernandes.apprestaurante.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
    private List<Review> review = new ArrayList<>();

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
    private List<Menu> menu = new ArrayList<>();

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
