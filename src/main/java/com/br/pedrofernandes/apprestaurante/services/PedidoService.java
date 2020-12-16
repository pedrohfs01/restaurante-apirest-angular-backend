package com.br.pedrofernandes.apprestaurante.services;

import com.br.pedrofernandes.apprestaurante.Repositories.ItemPedidoRepository;
import com.br.pedrofernandes.apprestaurante.Repositories.PedidoRepository;
import com.br.pedrofernandes.apprestaurante.domain.ItemPedido;
import com.br.pedrofernandes.apprestaurante.domain.Pedido;
import com.br.pedrofernandes.apprestaurante.dto.ItemPedidoDTO;
import com.br.pedrofernandes.apprestaurante.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class PedidoService {

    @Autowired
    PedidoRepository repo;

    @Autowired
    MenuService menuService;

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    public List<Pedido> findAll(){
        return repo.findAll();
    }

    public Pedido insert(Pedido pedido) {
        repo.save(pedido);
        itemPedidoRepository.saveAll(pedido.getOrderItems());
        return pedido;
    }

    public Pedido fromDTO(PedidoDTO objDTO){
        Pedido obj = new Pedido(objDTO.getAddress(), objDTO.getNumber(), objDTO.getOptionalAddress(), objDTO.getPaymentOptional());
        ItemPedido itemPedido = new ItemPedido();
        for(ItemPedidoDTO ip : objDTO.getOrderItems()){
            itemPedido.setQuantity(ip.getQuantity());
            itemPedido.setMenu(menuService.findMenuById(ip.getMenuId()).get());
            itemPedido.setPedidos(obj);
            obj.setOrderItems(Arrays.asList(itemPedido));
        }

        return obj;
    }
}
