package com.digitalyouthservices.efactures.model;

import lombok.Data;

@Data
public class Company {

    private String name;
    private String website;
    private String email;
    private Long SIRET;
    private String logo;
}
