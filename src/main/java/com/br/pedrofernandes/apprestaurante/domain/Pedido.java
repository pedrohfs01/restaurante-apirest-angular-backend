package com.br.pedrofernandes.apprestaurante.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String number;
    private String optionalAddress;
    private String paymentOptional;

    @OneToMany(mappedBy = "pedidos")
    private List<ItemPedido> orderItems = new ArrayList<>();

    public Pedido(){
    }

    public Pedido(String address, String number, String optionalAddress, String paymentOptional) {
        this.address = address;
        this.number = number;
        this.optionalAddress = optionalAddress;
        this.paymentOptional = paymentOptional;
    }
}
