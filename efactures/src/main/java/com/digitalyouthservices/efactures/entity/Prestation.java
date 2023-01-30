package com.digitalyouthservices.efactures.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prestation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;

    public Double Total(){
        double total = this.getPrice() * this.getQuantity();
        return total;
    }
}
