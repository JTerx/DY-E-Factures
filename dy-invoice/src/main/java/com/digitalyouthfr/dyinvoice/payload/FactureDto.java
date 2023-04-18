package com.digitalyouthfr.dyinvoice.payload;

import com.digitalyouthfr.dyinvoice.models.FactureEtat;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FactureDto {

    private Long id;
    private String number;
    private String prestations;
    private Date dateCreation= new Date();
    private ClientDto client;
    private UserDto user;
    private double montant;
    private FactureEtat etat;

}
