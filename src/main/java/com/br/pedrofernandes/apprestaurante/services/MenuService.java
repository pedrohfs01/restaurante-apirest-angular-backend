package com.br.pedrofernandes.apprestaurante.services;

import com.br.pedrofernandes.apprestaurante.Repositories.MenuRepository;
import com.br.pedrofernandes.apprestaurante.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository repo;

    public List<Menu> findMenu(String restauranteId){
        return repo.findAllByRestauranteId(restauranteId);
    }
}
