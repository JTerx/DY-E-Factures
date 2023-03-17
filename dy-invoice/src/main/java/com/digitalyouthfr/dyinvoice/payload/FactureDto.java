package com.digitalyouthfr.dyinvoice.payload;

import com.digitalyouthfr.dyinvoice.models.FactureEtat;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FactureDto {

    private Long id;
    private Long number;
    private String name;
    private Date dateCreation;
    private Long clientId;
    private Long userId;
    private double montant;
    private FactureEtat etat;
}
