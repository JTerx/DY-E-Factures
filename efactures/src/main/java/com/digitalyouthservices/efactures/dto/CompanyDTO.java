package com.digitalyouthservices.efactures.dto;

public class CompanyDTO {

    private Long id;
    private String name;

    private String website;

    private String email;

    private Long SIRET;

    private String logo;

    public CompanyDTO(Long id, String name, String website, String email, Long SIRET, String logo) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.email = email;
        this.SIRET = SIRET;
        this.logo = logo;
    }

    public CompanyDTO() {
    }
}
