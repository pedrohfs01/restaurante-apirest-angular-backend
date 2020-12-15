package com.br.pedrofernandes.apprestaurante.resources;

import com.br.pedrofernandes.apprestaurante.domain.User;
import com.br.pedrofernandes.apprestaurante.dto.UserDTO;
import com.br.pedrofernandes.apprestaurante.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;


    @GetMapping(value ="/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping(value ="/email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email){
        return new ResponseEntity<>(service.findByEmail(email), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> insert(@RequestBody UserDTO userDTO){
        User user = service.fromDTO(userDTO);
        return new ResponseEntity(service.insert(user), HttpStatus.CREATED);
    }
}
