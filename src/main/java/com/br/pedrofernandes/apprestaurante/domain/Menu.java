package com.br.pedrofernandes.apprestaurante.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @JsonIgnore
    private Restaurante restaurante;

    @OneToMany(mappedBy = "menuId")
    @JsonIgnore
    private Set<ItemPedido> items = new HashSet<>();

    public Menu(){}

    public Menu(String id, String name, String imagePath, String description, Double price) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.description = description;
        this.price = price;
    }
}
