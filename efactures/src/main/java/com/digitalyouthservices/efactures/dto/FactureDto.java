package com.digitalyouthservices.efactures.dto;

import java.time.LocalDate;
import java.util.List;


public class FactureDto {

    public Long id;
    public LocalDate dateEmission;
    public ClientFactureDto client;
    public List<PrestationDto> prestations;

    public FactureDto(Long id, LocalDate dateEmission, ClientFactureDto client, List<PrestationDto> prestations) {
        this.id = id;
        this.dateEmission = dateEmission;
        this.client = client;
        this.prestations = prestations;
    }

    public FactureDto(){

    }
}
