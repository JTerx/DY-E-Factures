package com.digitalyouthservices.efactures.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String email;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<FactureEntity> factures;
}
