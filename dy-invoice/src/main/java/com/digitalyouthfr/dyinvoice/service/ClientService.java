package com.digitalyouthfr.dyinvoice.service;

import com.digitalyouthfr.dyinvoice.payload.ClientDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    ClientDto createClient(ClientDto clientDto);

    ClientDto getClientById(long id);

    List<ClientDto> getAllClient();

    ClientDto updateClient(ClientDto clientDto, long id);

    void deleteClientById(long id);
}
