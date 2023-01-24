package com.digitalyouthservices.efactures.dto;

import java.util.List;

public class ClientDTO {

    private Long id;

    private String name;
    private String address;
    private String email;

    private List<FactureDTO> factures;

    public ClientDTO(Long id, String name, String address, String email, List<FactureDTO> factures) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.factures = factures;
    }

    public ClientDTO() {
    }
}
