package com.br.pedrofernandes.apprestaurante.resources;


import com.br.pedrofernandes.apprestaurante.domain.Menu;
import com.br.pedrofernandes.apprestaurante.domain.Restaurante;
import com.br.pedrofernandes.apprestaurante.domain.Review;
import com.br.pedrofernandes.apprestaurante.services.MenuService;
import com.br.pedrofernandes.apprestaurante.services.RestauranteService;
import com.br.pedrofernandes.apprestaurante.services.ReviewService;
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

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private MenuService menuService;

    @GetMapping()
    public ResponseEntity<List<Restaurante>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping()
    public ResponseEntity<Restaurante> insert(@RequestBody Restaurante obj){
        return new ResponseEntity<>(service.insert(obj), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}/reviews")
    public ResponseEntity<List<Review>> findReviews(@PathVariable String id){
        return new ResponseEntity<>(reviewService.findReviews(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/menu")
    public ResponseEntity<List<Menu>> findMenu(@PathVariable String id){
        return new ResponseEntity<>(menuService.findMenu(id), HttpStatus.OK);
    }

}
