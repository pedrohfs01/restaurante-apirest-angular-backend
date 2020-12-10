package com.br.pedrofernandes.apprestaurante.Repositories;

import com.br.pedrofernandes.apprestaurante.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {

    @Transactional
    public List<Menu> findAllByRestauranteId(@Param("restauranteId") String restauranteId);
}
