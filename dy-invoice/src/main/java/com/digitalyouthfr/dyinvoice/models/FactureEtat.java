package com.digitalyouthfr.dyinvoice.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public enum FactureEtat {

    EN_ATTENTE("En attente"),
    PAYEE("Payée"),
    ANNULEE("Annulée"),
    REMBOURSEE("Remboursée");

    private String displayName;

}
