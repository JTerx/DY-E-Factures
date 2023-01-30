package com.digitalyouthservices.efactures.dto;



public class PrestationDto {

    public Long id;
    public String name;
    public String description;
    public Double price;
    public int quantity;

    public PrestationDto(Long id, String name, String description, Double price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public PrestationDto(){

    }
}
