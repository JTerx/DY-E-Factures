package com.digitalyouthservices.efactures.services.clientService;


import com.digitalyouthservices.efactures.entity.ClientFacture;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClientService {

        ClientFacture create(ClientFacture clientFacture);
        void deleteById(Long clientId);
        Optional<ClientFacture> findById(Long clientId);
        List<ClientFacture> findAll();

}
