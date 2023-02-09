package com.digitalyouthservices.efactures.service;


import com.digitalyouthservices.efactures.dto.ClientDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    ClientDto createClient(ClientDto clientDto);

    ClientDto getClientById(Long clientId);

    List<ClientDto> getAllClient();

    void deleteClient(Long clientId);

}
