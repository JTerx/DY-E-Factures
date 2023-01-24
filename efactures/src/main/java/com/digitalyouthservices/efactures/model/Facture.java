package com.digitalyouthservices.efactures.model;

import com.digitalyouthservices.efactures.entity.ClientEntity;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
public class Facture {
    private Long factureNumber;
    private LocalDate dateEmission;
    private LocalDate dataEmission;
    private int clientId;
}
