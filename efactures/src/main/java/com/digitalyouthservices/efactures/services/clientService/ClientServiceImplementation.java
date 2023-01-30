package com.digitalyouthservices.efactures.services.clientService;

import com.digitalyouthservices.efactures.entity.ClientFacture;
import com.digitalyouthservices.efactures.exception.ResourceAlreadyExistException;
import com.digitalyouthservices.efactures.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImplementation implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImplementation(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientFacture create(ClientFacture clientFacture) {
        Optional<ClientFacture> currentClient = clientRepository.findById(clientFacture.getId());

        if(!currentClient.isPresent()) {
            clientRepository.save(clientFacture);
        }
            throw new ResourceAlreadyExistException("Not Found");

    }
    @Override
    public void deleteById(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public Optional<ClientFacture> findById(Long clientId) {
        return clientRepository.findById(clientId);
    }

    @Override
    public List<ClientFacture> findAll() {
        return clientRepository.findAll();
    }
}
