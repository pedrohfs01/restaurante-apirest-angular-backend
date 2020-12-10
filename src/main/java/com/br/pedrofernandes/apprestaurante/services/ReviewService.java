package com.br.pedrofernandes.apprestaurante.services;

import com.br.pedrofernandes.apprestaurante.Repositories.ReviewRepository;
import com.br.pedrofernandes.apprestaurante.domain.Menu;
import com.br.pedrofernandes.apprestaurante.domain.Restaurante;
import com.br.pedrofernandes.apprestaurante.domain.Review;
import com.br.pedrofernandes.apprestaurante.dto.MenuDTO;
import com.br.pedrofernandes.apprestaurante.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repo;

    @Autowired
    private RestauranteService restauranteService;

    public List<Review> findReviews(String restauranteId){
        return repo.findAllByRestauranteId(restauranteId);
    }

    public Review insert(Review obj){
        Optional<Restaurante> rest = restauranteService.findById(obj.getRestaurante().getId());
        obj.setRestaurante(rest.get());
        return repo.save(obj);
    }

    public Review fromDTO(ReviewDTO objDTO){
        Review obj = new Review(objDTO.getId(), objDTO.getName(), objDTO.getDate(), objDTO.getRating(), objDTO.getComments());
        Restaurante rest = new Restaurante();
        rest.setId(objDTO.getRestauranteId());
        obj.setRestaurante(rest);
        return obj;
    }
}
