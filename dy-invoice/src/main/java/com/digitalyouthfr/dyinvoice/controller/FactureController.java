package com.digitalyouthfr.dyinvoice.controller;

import com.digitalyouthfr.dyinvoice.payload.FactureDto;
import com.digitalyouthfr.dyinvoice.service.FactureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facture/")
public class FactureController {

    final private FactureService factureService;


    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }


    @GetMapping
    public ResponseEntity<List<FactureDto>> getAllFactures() {

        return ResponseEntity.ok(factureService.getAllFactures());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FactureDto> getFactureById(@PathVariable("id") Long factureId){
        FactureDto factureDto = factureService.getFactureById(factureId);

        return ResponseEntity.ok(factureDto);
    }

    @GetMapping("/number/{number}")
    public ResponseEntity<FactureDto> getFactureByNumber(@PathVariable("number") String number){
        FactureDto factureDto = factureService.getFactureByNumber(number);

        return ResponseEntity.ok(factureDto);
    }

    @PostMapping("/create")
    public ResponseEntity<FactureDto> createFacture(@RequestBody FactureDto factureDto){

        FactureDto saveFacture = factureService.createFacture(factureDto);

        return new ResponseEntity<>(saveFacture, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FactureDto> updateFacture(@PathVariable Long id, @RequestBody FactureDto factureDto) {
        FactureDto updatedFacture = factureService.updateFacture(id, factureDto);
        return ResponseEntity.ok(updatedFacture);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFacture(@PathVariable("id") Long factureId){

        factureService.deleteFactureById(factureId);
        return ResponseEntity.ok("Facture Delete Success");
    }

    @GetMapping("/client/{id}")
    public List<FactureDto> getFacturesByClientId(@PathVariable("id") Long clientId) {
        return factureService.getFacturesByClientId(clientId);
    }


}
