package com.digitalyouthservices.efactures.entity;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phone;
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;



}
