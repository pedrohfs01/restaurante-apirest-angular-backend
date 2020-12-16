package com.br.pedrofernandes.apprestaurante.dto;

import lombok.Data;

import java.util.List;

@Data
public class PedidoDTO {


    private String address;
    private String number;
    private String optionalAddress;
    private String paymentOptional;

    private List<ItemPedidoDTO> orderItems;
}
