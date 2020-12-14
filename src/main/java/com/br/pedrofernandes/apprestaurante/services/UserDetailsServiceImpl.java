package com.br.pedrofernandes.apprestaurante.services;

import com.br.pedrofernandes.apprestaurante.Repositories.UserRepository;
import com.br.pedrofernandes.apprestaurante.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User usuario = repository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Login não encontrado.") );

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword())
                .roles("USER")
                .build()
                ;
    }
}
