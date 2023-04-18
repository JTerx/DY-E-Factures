package com.digitalyouthfr.dyinvoice.service;

import com.digitalyouthfr.dyinvoice.payload.ClientDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    ClientDto createClient(ClientDto clientDto);

    ClientDto getClientById(Long id);

    List<ClientDto> getAllClient();

    ClientDto updateClient(ClientDto clientDto, Long id);

    ClientDto findClientByMail(String email);
    void deleteClientById(Long id);
}
