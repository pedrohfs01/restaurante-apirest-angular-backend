package com.br.pedrofernandes.apprestaurante.services;

import com.br.pedrofernandes.apprestaurante.Repositories.UserRepository;
import com.br.pedrofernandes.apprestaurante.domain.User;
import com.br.pedrofernandes.apprestaurante.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    @Autowired
    private BCryptPasswordEncoder pe;

    public User findById(Long id){
        Optional<User> obj = repo.findById(id);
        return obj.get();
    }

    public User findByEmail(String email){
        User obj = repo.findByEmail(email);
        return obj;
    }

    public User insert(User user){
        return repo.save(user);
    }

    public User fromDTO(UserDTO userDTO){
        User obj = new User(userDTO.getEmail(), pe.encode(userDTO.getPassword()), userDTO.getName());
        return obj;
    }
}
