package com.digitalyouthservices.efactures.service.Implementation;


import com.digitalyouthservices.efactures.dto.ClientDto;
import com.digitalyouthservices.efactures.entity.Client;
import com.digitalyouthservices.efactures.exception.ResourceAlreadyExistException;
import com.digitalyouthservices.efactures.exception.ResourceNotFoundException;
import com.digitalyouthservices.efactures.repository.ClientRepository;
import com.digitalyouthservices.efactures.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImplementation implements ClientService {

    private final ClientRepository clientRepository;

    private ModelMapper modelMapper;

    @Autowired
    public ClientServiceImplementation(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);
        Optional<Client> currentClient = clientRepository.findByName(client.getName());
        if(!currentClient.isPresent()) {
            Client saveClient = clientRepository.save(client);
            return modelMapper.map(saveClient, ClientDto.class);
        }

        throw new ResourceAlreadyExistException("This client already exists", client.getName());
    }

    @Override
    public ClientDto getClientById(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found","id", clientId));

        return modelMapper.map(client, ClientDto.class);
    }

    @Override
    public List<ClientDto> getAllClient() {
        List<Client> clients = clientRepository.findAll();

        return clients
                .stream()
                .map((client) -> modelMapper.map(client, ClientDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client " + clientId + "Not found"));

        clientRepository.delete(client);

    }
}
