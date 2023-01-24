package com.digitalyouthservices.efactures.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phone;
    @OneToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;



}
