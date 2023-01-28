package com.digitalyouthservices.efactures.repository;

import com.digitalyouthservices.efactures.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {

}
