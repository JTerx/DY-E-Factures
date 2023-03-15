package com.digitalyouthfr.dyinvoice.models;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private int phoneNumber;

    @OneToMany(mappedBy = "client")
    private Set<Facture> factures;

}
