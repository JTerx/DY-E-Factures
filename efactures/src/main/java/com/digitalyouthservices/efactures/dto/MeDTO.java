package com.digitalyouthservices.efactures.dto;

public class MeDTO {

    private Long id;
    private UserDTO user;
    private CompanyDTO company;

    public MeDTO(Long id, UserDTO user, CompanyDTO company) {
        this.id = id;
        this.user = user;
        this.company = company;
    }

    public MeDTO() {
    }
}
