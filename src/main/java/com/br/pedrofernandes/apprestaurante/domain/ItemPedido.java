package com.br.pedrofernandes.apprestaurante.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @ManyToOne()
    @JoinColumn(name = "items_id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "orderItems_id")
    @JsonIgnore
    private Pedido pedidos;



    public ItemPedido(){
    }
}
