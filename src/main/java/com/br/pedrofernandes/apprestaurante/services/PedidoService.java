package com.br.pedrofernandes.apprestaurante.services;

import com.br.pedrofernandes.apprestaurante.Repositories.ItemPedidoRepository;
import com.br.pedrofernandes.apprestaurante.Repositories.PedidoRepository;
import com.br.pedrofernandes.apprestaurante.domain.ItemPedido;
import com.br.pedrofernandes.apprestaurante.domain.Pedido;
import com.br.pedrofernandes.apprestaurante.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repo;

    @Autowired
    MenuService menuService;

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    public Pedido insert(Pedido pedido) {
        repo.save(pedido);
        for (ItemPedido ip : pedido.getOrderItems()) {
            ip.setMenuId(menuService.findMenuById(ip.getMenuId().getId()).get());
        }
        itemPedidoRepository.saveAll(pedido.getOrderItems());
        return pedido;
    }

    public Pedido fromDTO(PedidoDTO objDTO){
        Pedido obj = new Pedido(objDTO.getAddress(), objDTO.getNumber(), objDTO.getOptionalAddress(), objDTO.getPaymentOptional());
        for(ItemPedido ip : objDTO.getOrderItems()){
            obj.setOrderItems(objDTO.getOrderItems());
        }
        return obj;
    }
}
