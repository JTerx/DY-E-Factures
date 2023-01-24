package com.digitalyouthservices.efactures.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class FactureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long factureNumber;
    private LocalDate dateEmission;
    private LocalDate dataEmission;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;
    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL)
    private List<ArticleEntity> articles;
    private Double total;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;
    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL)
    private List<PaiementEntity> paiements;
    //getters and setters
}
