package com.digitalyouthservices.efactures.model;

import com.digitalyouthservices.efactures.entity.CompanyEntity;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private Integer phone;
    private String password;

}
