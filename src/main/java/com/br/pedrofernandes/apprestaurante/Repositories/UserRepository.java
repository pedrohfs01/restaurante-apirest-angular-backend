package com.br.pedrofernandes.apprestaurante.Repositories;

import com.br.pedrofernandes.apprestaurante.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
