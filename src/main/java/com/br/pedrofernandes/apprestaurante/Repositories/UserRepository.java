package com.br.pedrofernandes.apprestaurante.Repositories;

import com.br.pedrofernandes.apprestaurante.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional()
    public User findByEmail(String email);
}
