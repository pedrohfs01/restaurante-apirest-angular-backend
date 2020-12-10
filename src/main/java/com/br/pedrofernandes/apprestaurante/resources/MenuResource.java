package com.br.pedrofernandes.apprestaurante.resources;

import com.br.pedrofernandes.apprestaurante.domain.Menu;
import com.br.pedrofernandes.apprestaurante.domain.Restaurante;
import com.br.pedrofernandes.apprestaurante.dto.MenuDTO;
import com.br.pedrofernandes.apprestaurante.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/menu")
public class MenuResource {
    @Autowired
    private MenuService service;

    @PostMapping()
    public ResponseEntity<Restaurante> insert(@RequestBody MenuDTO objDTO){
        Menu obj = service.fromDTO(objDTO);
        return new ResponseEntity(service.insert(obj), HttpStatus.CREATED);
    }

}
