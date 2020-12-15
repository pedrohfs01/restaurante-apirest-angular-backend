package com.br.pedrofernandes.apprestaurante.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ItemPedido {

    private Integer quantity;

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    @JsonIgnore
    public Pedido getPedido() {
        return id.getPedido();
    }

    public Menu getMenu() {
        return id.getMenu();
    }

    public void setPedido(Pedido pedido) {
        id.setPedido(pedido);
    }

    public void setMenu(Menu menu) {
        id.setMenu(menu);
    }
}
