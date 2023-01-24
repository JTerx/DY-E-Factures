package com.digitalyouthservices.efactures.services.factureService;

import com.digitalyouthservices.efactures.dto.FactureDTO;
import com.digitalyouthservices.efactures.entity.FactureEntity;
import com.digitalyouthservices.efactures.model.response.DataResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Facture {

    public abstract ResponseEntity<DataResponse<FactureDTO>> createFacture(FactureEntity facture);
    public abstract ResponseEntity<DataResponse<FactureDTO>> deleteFacture(int factureId);
    public abstract ResponseEntity<DataResponse<FactureDTO>> updateFacture(int factureId, FactureEntity facture);
    public abstract ResponseEntity<DataResponse<FactureDTO>> getFactureById(int factureId);
    public abstract ResponseEntity<DataResponse<List<FactureDTO>>> getAllFactures();

}
