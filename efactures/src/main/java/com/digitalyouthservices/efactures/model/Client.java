package com.digitalyouthservices.efactures.model;

import com.digitalyouthservices.efactures.entity.FactureEntity;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class Client {

    private String name;
    private String address;
    private String email;
    private List<Facture> factures;
}
