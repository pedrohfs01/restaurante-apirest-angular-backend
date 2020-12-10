package com.br.pedrofernandes.apprestaurante.Repositories;

import com.br.pedrofernandes.apprestaurante.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Transactional
    public List<Review> findAllByRestauranteId(@Param("restauranteId")String restauranteId);

}
