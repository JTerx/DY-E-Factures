package com.digitalyouthfr.dyinvoice.service;

import com.digitalyouthfr.dyinvoice.payload.FactureDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FactureService {

    List<FactureDto> getAllFactures();

    FactureDto getFactureById(Long id);

    FactureDto getFactureByNumber(Long number);

    FactureDto createFacture(Long clientId, Long userId,FactureDto factureDto);

    FactureDto updateFacture(Long id, FactureDto factureDto);

    void deleteFactureById(Long id);

    List<FactureDto> getFacturesByUserId(Long userId);

    List<FactureDto> getFacturesByClientId(Long clientId);
}
