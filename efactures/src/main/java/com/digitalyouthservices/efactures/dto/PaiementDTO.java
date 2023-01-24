package com.digitalyouthservices.efactures.dto;

import java.time.LocalDate;

public class PaiementDTO {
    private Long id;
    private LocalDate date;
    private Double amount;
    private FactureDTO facture;

    public PaiementDTO(Long id, LocalDate date, Double amount, FactureDTO facture) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.facture = facture;
    }

    public PaiementDTO() {
    }
}
