package com.digitalyouthservices.efactures.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String website;
    private String email;
    private Long SIRET;
    private String logo;
    @OneToOne(mappedBy = "company")
    private UserEntity user;
    @OneToMany(mappedBy = "company")
    private List<FactureEntity> factures;
}
