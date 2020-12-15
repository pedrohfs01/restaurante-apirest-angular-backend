package com.br.pedrofernandes.apprestaurante.dto;

import com.br.pedrofernandes.apprestaurante.domain.ItemPedido;
import lombok.Data;

import java.util.List;

@Data
public class PedidoDTO {
    private String address;
    private String number;
    private String optionalAddress;
    private String paymentOptional;

    private List<ItemPedido> orderItems;
}
