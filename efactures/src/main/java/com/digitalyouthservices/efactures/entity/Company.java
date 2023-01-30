package com.digitalyouthservices.efactures.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;
    @OneToMany(mappedBy = "company")
    private List<Facture> facture;
}
