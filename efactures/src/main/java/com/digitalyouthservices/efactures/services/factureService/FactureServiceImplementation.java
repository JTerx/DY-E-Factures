package com.digitalyouthservices.efactures.services.factureService;

import com.digitalyouthservices.efactures.entity.Facture;
import com.digitalyouthservices.efactures.entity.Prestation;
import com.digitalyouthservices.efactures.exception.ResourceAlreadyExistException;
import com.digitalyouthservices.efactures.repository.FactureRepository;
import com.digitalyouthservices.efactures.repository.PrestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureServiceImplementation implements FactureService{

    private final FactureRepository factureRepository;
    private final PrestationRepository prestationRepository;

    @Autowired
    public FactureServiceImplementation(FactureRepository factureRepository, PrestationRepository prestationRepository) {
        this.factureRepository = factureRepository;
        this.prestationRepository = prestationRepository;
    }

    @Override
    public Facture create(Facture facture) {
        Optional<Facture> currentFacture = factureRepository.findById(facture.getId());
        if(!currentFacture.isPresent()){
            factureRepository.save(facture);
        }
        throw new ResourceAlreadyExistException("Facture  already exists");
    }

    @Override
    public Optional<Facture> findById(Long factureId) {
        return factureRepository.findById(factureId);
    }

    @Override
    public void deleteById(Long factureId) {
        factureRepository.deleteById(factureId);
    }

    @Override
    public List<Facture> findAll() {
        return factureRepository.findAll();
    }

    @Override
    public Prestation createPrestation(Long factureId, Prestation prestation) {
        Optional<Facture> currentFacture = factureRepository.findById(factureId);
        Optional<Prestation> currentPrestation = prestationRepository.findById(prestation.getId());

        if(currentFacture.isEmpty()) {
            throw new ResourceNotFoundException("The receipts " + factureId + " does not exist");
        }
        if(currentPrestation.isEmpty()) {
            throw new ResourceNotFoundException("The prestation "+ prestation.getName() + " does not exist");
        }
        prestation.setFacture(currentFacture.get());

        return prestationRepository.save(prestation);

    }
    @Override
    public Optional<Prestation> findPrestationById(Long factureId, Long prestationId) {
        return Optional.empty();
    }
    @Override
    public void deletePrestationById(Long factureId, Long prestationId) {

    }
}
