package com.digitalyouthservices.efactures.services.clientService;

import com.digitalyouthservices.efactures.dto.ClientDTO;
import com.digitalyouthservices.efactures.entity.ClientEntity;
import com.digitalyouthservices.efactures.model.response.DataResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Client {

    public abstract ResponseEntity<DataResponse<ClientDTO>> createClient(ClientEntity client);
    public abstract ResponseEntity<DataResponse<ClientDTO>> updateClient(int clientId, ClientEntity client);
    public abstract ResponseEntity<DataResponse<ClientDTO>> deleteClient(int client);
    public abstract ResponseEntity<DataResponse<ClientDTO>> getClientById(int client);
    public abstract ResponseEntity<DataResponse<List<ClientDTO>>> getAllClients();
}
