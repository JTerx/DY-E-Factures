package com.digitalyouthservices.efactures.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String email;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Facture> facture;
}
