package com.br.pedrofernandes.apprestaurante.resources;

import com.br.pedrofernandes.apprestaurante.domain.Pedido;
import com.br.pedrofernandes.apprestaurante.dto.PedidoDTO;
import com.br.pedrofernandes.apprestaurante.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value ="/orders")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody PedidoDTO objDTO){
        Pedido pedido = pedidoService.fromDTO(objDTO);
        return new ResponseEntity(pedidoService.insert(pedido), HttpStatus.CREATED);
    }
}
