package com.digitalyouthfr.dyinvoice.models;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
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
    private Long phoneNumber;
    private String address;
    @OneToMany(mappedBy = "client")
    private Set<Facture> facture;


    public Client(Long id){
        this.id = id;
    }

}
