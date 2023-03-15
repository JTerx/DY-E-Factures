package com.digitalyouthfr.dyinvoice.service.implementation;

import com.digitalyouthfr.dyinvoice.exceptions.ClientExistException;
import com.digitalyouthfr.dyinvoice.exceptions.ResourceNotFoundException;
import com.digitalyouthfr.dyinvoice.models.Client;
import com.digitalyouthfr.dyinvoice.payload.ClientDto;
import com.digitalyouthfr.dyinvoice.repository.ClientRepository;
import com.digitalyouthfr.dyinvoice.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImplementation implements ClientService {

    private final ClientRepository clientRepository;

    private ModelMapper mapper;

    public ClientServiceImplementation(ClientRepository clientRepository, ModelMapper mapper) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        Client client = mapper.map(clientDto, Client.class);
        Optional<Client> currentClient = clientRepository.findByEmail(client.getEmail());
        if(!currentClient.isPresent()){
            Client saveClient = clientRepository.save(client);
            return mapper.map(saveClient, ClientDto.class);
        }else {
            throw new ClientExistException("Client already exists", client.getEmail());
        }

    }

    @Override
    public ClientDto getClientById(long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("client", "id", id));
        return mapper.map(client, ClientDto.class);
    }

    @Override
    public List<ClientDto> getAllClient() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream().map((client) -> mapper.map(client, ClientDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto, long id) {
        return null;
    }

    @Override
    public void deleteClientById(long id) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));

        clientRepository.delete(client);

    }
}
