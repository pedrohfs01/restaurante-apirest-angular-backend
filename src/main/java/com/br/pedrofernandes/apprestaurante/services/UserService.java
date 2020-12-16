package com.br.pedrofernandes.apprestaurante.services;

import com.br.pedrofernandes.apprestaurante.Repositories.UserRepository;
import com.br.pedrofernandes.apprestaurante.domain.User;
import com.br.pedrofernandes.apprestaurante.dto.UserDTO;
import com.br.pedrofernandes.apprestaurante.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User findById(Long id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto: id: "+id+" não encontrado."));
    }

    public User findByEmail(String email){
        Optional<User> obj = repo.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto: email: "+email+" não encontrado."));
    }

    public User insert(User user){
        return repo.save(user);
    }

    public User fromDTO(UserDTO userDTO){
        User obj = new User(userDTO.getEmail(), userDTO.getPassword(), userDTO.getName());
        return obj;
    }
}
