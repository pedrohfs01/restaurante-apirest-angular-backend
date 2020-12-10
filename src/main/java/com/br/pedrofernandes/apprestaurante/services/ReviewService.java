package com.br.pedrofernandes.apprestaurante.services;

import com.br.pedrofernandes.apprestaurante.Repositories.ReviewRepository;
import com.br.pedrofernandes.apprestaurante.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repo;

    public List<Review> findReviews(String restauranteId){
        return repo.findAllByRestauranteId(restauranteId);
    }
}
