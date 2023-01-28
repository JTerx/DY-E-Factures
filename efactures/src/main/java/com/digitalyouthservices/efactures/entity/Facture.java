package com.digitalyouthservices.efactures.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long factureNumber;
    private LocalDate dateEmission;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientFacture clientFacture;
    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL)
    private Set<Prestation> prestations;
    private Double total;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    //getters and setters
}
