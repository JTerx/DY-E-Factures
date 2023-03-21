package com.digitalyouthfr.dyinvoice.repository;

import com.digitalyouthfr.dyinvoice.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {


    Optional<Facture> findByNumber(String number);
}
