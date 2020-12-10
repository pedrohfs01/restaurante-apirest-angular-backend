package com.br.pedrofernandes.apprestaurante.services;

import com.br.pedrofernandes.apprestaurante.Repositories.RestauranteRepository;
import com.br.pedrofernandes.apprestaurante.domain.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository repo;


    public List<Restaurante> findAll(){
        return repo.findAll();

    }

    public Optional<Restaurante> findById(String id){
        return repo.findById(id);
    }

    public Restaurante insert(Restaurante obj){
        return repo.save(obj);
    }

}
