package com.digitalyouthfr.dyinvoice.service;

import com.digitalyouthfr.dyinvoice.payload.FactureDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FactureService {

    List<FactureDto> getAllFactures();

    FactureDto getFactureById(Long id);

    FactureDto getFactureByNumber(String number);

    FactureDto createFacture(FactureDto factureDto);

    FactureDto updateFacture(Long id, FactureDto factureDto);

    void deleteFactureById(Long id);

    List<FactureDto> getFacturesByUserId(Long userId);

    List<FactureDto> getFacturesByClientId(Long clientId);
}
