package com.digitalyouthfr.dyinvoice.controller;

import com.digitalyouthfr.dyinvoice.payload.ClientDto;
import com.digitalyouthfr.dyinvoice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAllClients(){
        return ResponseEntity.ok(clientService.getAllClient());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable("id") Long clientId) {
        ClientDto clientDto = clientService.getClientById(clientId);
        return ResponseEntity.ok(clientDto);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ClientDto> getClientByEmail(@PathVariable("email") String email) {
        ClientDto clientDto = clientService.findClientByMail(email);

        return ResponseEntity.ok(clientDto);
    }

    @PostMapping(value = {"/create"})
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto){
        ClientDto saveClient = clientService.createClient(clientDto);
        return new ResponseEntity<>(saveClient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long clientId) {
        clientService.deleteClientById(clientId);
        return ResponseEntity.ok("Client Delete Successfully!!");
    }



}
