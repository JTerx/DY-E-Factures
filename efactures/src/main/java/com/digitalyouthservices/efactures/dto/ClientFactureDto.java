package com.digitalyouthservices.efactures.dto;

import java.util.List;

public class ClientFactureDto {

    public Long id;
    public String name;
    public String address;
    public String email;
    public List<FactureDto> factures;

    public ClientFactureDto(Long id, String name, String address, String email, List<FactureDto> factures) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.factures = factures;
    }

    public ClientFactureDto() {
    }
}
