package com.digitalyouthservices.efactures.model;

import com.digitalyouthservices.efactures.entity.FactureEntity;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class Article {

    private String name;
    private String description;
    private Double price;
    private int factureid;
}
