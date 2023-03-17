package com.digitalyouthfr.dyinvoice.service.implementation;

import com.digitalyouthfr.dyinvoice.exceptions.FactureExistException;
import com.digitalyouthfr.dyinvoice.exceptions.ResourceNotFoundException;
import com.digitalyouthfr.dyinvoice.models.Client;
import com.digitalyouthfr.dyinvoice.models.Facture;
import com.digitalyouthfr.dyinvoice.models.FactureEtat;
import com.digitalyouthfr.dyinvoice.models.User;
import com.digitalyouthfr.dyinvoice.payload.FactureDto;
import com.digitalyouthfr.dyinvoice.repository.ClientRepository;
import com.digitalyouthfr.dyinvoice.repository.FactureRepository;
import com.digitalyouthfr.dyinvoice.repository.UserRepository;
import com.digitalyouthfr.dyinvoice.service.FactureService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class FactureServiceImplementation implements FactureService {

    private final FactureRepository factureRepository;
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private ModelMapper mapper;

    public FactureServiceImplementation(FactureRepository factureRepository, ClientRepository clientRepository, UserRepository userRepository, ModelMapper mapper) {
        this.factureRepository = factureRepository;
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }


    @Override
    public List<FactureDto> getAllFactures() {
        List<Facture> factures = factureRepository.findAll();

        return factures.stream().map((facture) -> mapper.map(facture, FactureDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FactureDto getFactureById(Long id) {
        Facture facture = factureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facture", "id", id));

        return mapper.map(facture, FactureDto.class);
    }

    @Override
    public FactureDto getFactureByNumber(Long number) {
        Facture facture = factureRepository.findByNumber(number)
                .orElseThrow(() -> new ResourceNotFoundException("Facture", "number", number));
        return mapper.map(facture, FactureDto.class);
    }

    @Override
    public FactureDto createFacture(Long clientId, Long userId,FactureDto factureDto) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("client", "id", clientId));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

        Facture facture = mapper.map(factureDto, Facture.class);
        Optional<Facture> currentFacture = factureRepository.findByNumber(facture.getNumber());
        if(!currentFacture.isPresent()){

            facture.setClient(client);
            facture.setUser(user);
            facture.setEtat(FactureEtat.EN_ATTENTE);

            Facture saveFacture = factureRepository.save(facture);
            return mapper.map(saveFacture, FactureDto.class);
        }else{
            throw new FactureExistException("Facture already exists", facture.getNumber());
        }



    }

    @Override
    public FactureDto updateFacture(Long id, FactureDto factureDto) {

        Facture facture = factureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("facture", "id", id));
        mapper.map(factureDto, facture);
        Facture updatedFacture = factureRepository.save(facture);
        return mapper.map(updatedFacture, FactureDto.class);
    }

    @Override
    public void deleteFactureById(Long id) {

        Facture facture = factureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facture", "id", id));

        factureRepository.delete(facture);

    }

    @Override
    public List<FactureDto> getFacturesByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        List<Facture> factures = user.getFactures()
                .stream()
                .collect(Collectors.toList());


        return factures.stream().map(facture -> mapper.map(facture, FactureDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<FactureDto> getFacturesByClientId(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", clientId));

        Set<Facture> factures = client.getFactures();
        List<FactureDto> factureDtos = factures.stream().map(facture -> mapper.map(facture, FactureDto.class))
                .collect(Collectors.toList());

        return factureDtos;
    }
}
