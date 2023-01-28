package com.digitalyouthservices.efactures.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String website;
    private String email;
    private Long SIRET;
    private String logo;
    @OneToOne(mappedBy = "company")
    private UserAccount userAccount;
    @OneToMany(mappedBy = "company")
    private List<Facture> factures;
}
