package com.br.pedrofernandes.apprestaurante.resources;

import com.br.pedrofernandes.apprestaurante.domain.User;
import com.br.pedrofernandes.apprestaurante.dto.UserDTO;
import com.br.pedrofernandes.apprestaurante.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthResource {

    @Autowired
    private UserService service;

    @PostMapping(value = "/login")
    public ResponseEntity<User> login(@RequestBody UserDTO userDTO){
        User user = service.fromDTO(userDTO);

        return new ResponseEntity<>(service.findByEmail(user.getEmail()), HttpStatus.ACCEPTED);
    }
}
