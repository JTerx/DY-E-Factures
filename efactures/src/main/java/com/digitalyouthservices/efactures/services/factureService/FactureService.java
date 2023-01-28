package com.digitalyouthservices.efactures.services.factureService;

import com.digitalyouthservices.efactures.entity.Facture;
import com.digitalyouthservices.efactures.entity.Prestation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FactureService {

    Facture create(Facture facture);
    Optional<Facture> findById(Long factureId);
    void deleteById(Long factureId);
    List<Facture> findAll();
    Prestation createPrestation(Long factureId, Prestation prestation);
    Optional<Prestation> findPrestationById(Long factureId, Long prestationId);
    void deletePrestationById(Long factureId, Long prestationId);

}
