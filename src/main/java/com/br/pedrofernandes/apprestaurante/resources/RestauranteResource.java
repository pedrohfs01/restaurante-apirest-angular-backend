package com.br.pedrofernandes.apprestaurante.resources;


import com.br.pedrofernandes.apprestaurante.domain.Restaurante;
import com.br.pedrofernandes.apprestaurante.services.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes")
@CrossOrigin
public class RestauranteResource {

    @Autowired
    private RestauranteService service;

    @GetMapping()
    public ResponseEntity<List<Restaurante>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping()
    public ResponseEntity<Restaurante> insert(@RequestBody Restaurante obj){
        return new ResponseEntity<>(service.insert(obj), HttpStatus.CREATED);
    }

}
