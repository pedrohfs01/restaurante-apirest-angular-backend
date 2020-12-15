package com.br.pedrofernandes.apprestaurante.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @ManyToOne()
    @JoinColumn(name = "items_id")
    @JsonIgnore
    private Menu menuId;

    @ManyToOne
    @JoinColumn(name = "orderItems_id")
    @JsonIgnore
    private Pedido pedidos;

    public ItemPedido(){
    }
}
