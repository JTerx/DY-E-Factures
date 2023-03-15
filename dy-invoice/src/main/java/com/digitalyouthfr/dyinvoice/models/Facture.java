package com.digitalyouthfr.dyinvoice.models;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facture")

public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private double montant;

    // nouveau champ pour stocker l'état de la facture (en attente, payée, annulée, etc.)
    @Enumerated(EnumType.STRING)
    private FactureEtat etat;
}
