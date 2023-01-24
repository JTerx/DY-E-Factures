package com.digitalyouthservices.efactures.dto;

public class ArticleDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;

    public ArticleDTO(Long id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ArticleDTO() {
    }
}
