package com.digitalyouthservices.efactures.model;

import com.digitalyouthservices.efactures.entity.FactureEntity;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
public class Paiement {
    private LocalDate date;
    private Double amount;
    private int factureId;
}
