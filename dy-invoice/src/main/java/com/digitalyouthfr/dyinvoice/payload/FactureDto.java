package com.digitalyouthfr.dyinvoice.payload;

import com.digitalyouthfr.dyinvoice.models.Client;
import com.digitalyouthfr.dyinvoice.models.FactureEtat;
import com.digitalyouthfr.dyinvoice.models.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FactureDto {

    private String number;
    private String name;
    private Date dateCreation= new Date();
    private ClientDto client;
    private UserDto user;
    private double montant;
    private FactureEtat etat;

}
