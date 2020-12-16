package com.br.pedrofernandes.apprestaurante.services;

import com.br.pedrofernandes.apprestaurante.Repositories.MenuRepository;
import com.br.pedrofernandes.apprestaurante.Repositories.RestauranteRepository;
import com.br.pedrofernandes.apprestaurante.domain.Menu;
import com.br.pedrofernandes.apprestaurante.domain.Restaurante;
import com.br.pedrofernandes.apprestaurante.dto.MenuDTO;
import com.br.pedrofernandes.apprestaurante.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository repo;

    @Autowired
    private RestauranteService restauranteService;

    public List<Menu> findMenu(String restauranteId){
        return repo.findAllByRestauranteId(restauranteId);
    }

    public Menu findMenuById(String menuId) {
        Optional<Menu> obj = repo.findById(menuId);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto "+menuId+" não encontrado."));
    }

    public Menu insert(Menu obj){
        Optional<Restaurante> rest = restauranteService.findById(obj.getRestaurante().getId());
        obj.setRestaurante(rest.get());
        return repo.save(obj);
      }

    public Menu fromDTO(MenuDTO objDTO){
        Menu obj = new Menu(objDTO.getId(), objDTO.getName(), objDTO.getImagePath()
        , objDTO.getDescription(), objDTO.getPrice());
        Restaurante rest = new Restaurante();
        rest.setId(objDTO.getRestauranteId());
        obj.setRestaurante(rest);
        return obj;
    }
}
