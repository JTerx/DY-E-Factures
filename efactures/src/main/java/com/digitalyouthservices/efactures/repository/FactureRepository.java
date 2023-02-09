package com.digitalyouthservices.efactures.repository;

import com.digitalyouthservices.efactures.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

}
