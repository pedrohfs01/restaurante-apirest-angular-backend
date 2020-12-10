package com.br.pedrofernandes.apprestaurante.resources;


import com.br.pedrofernandes.apprestaurante.domain.Restaurante;
import com.br.pedrofernandes.apprestaurante.services.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteResource {

    @Autowired
    private RestauranteService service;

    @GetMapping()
    public ResponseEntity<List<Restaurante>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

}
