package com.br.pedrofernandes.apprestaurante.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MenuDTO {
    private String id;
    private String name;
    private String imagePath;
    private String description;
    private Double price;
    private String restauranteId;
}
