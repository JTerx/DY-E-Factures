package com.digitalyouthfr.dyinvoice.service.implementation;

import com.digitalyouthfr.dyinvoice.exceptions.BadRequestException;
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

import java.util.Date;
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

    //Generate Facture Number
    private String generateFactureNumber(Facture facture) {
        Date dateCreation = facture.getDateCreation();
        int year = dateCreation.getYear() + 1900;
        int month = dateCreation.getMonth() + 1;
        int day = dateCreation.getDate();
        Long id = facture.getId();
        return String.format("%d%02d%02d%04d", year, month, day, id);
    }


    @Override
    public FactureDto createFacture(FactureDto factureDto) {
        Facture facture = mapper.map(factureDto, Facture.class);

        Client client = clientRepository.findById(factureDto.getClient().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", factureDto.getClient().getId()));
        facture.setClient(client);

        User user = userRepository.findById(factureDto.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", factureDto.getUser().getId()));
        facture.setUser(user);

        Optional<Facture> currentFacture = factureRepository.findByNumber(facture.getNumber());
        if (!currentFacture.isPresent()) {
            facture.setEtat(FactureEtat.EN_ATTENTE);
            factureRepository.save(facture);
            String factureNumber = generateFactureNumber(facture);
            facture.setNumber(factureNumber);
            Facture savedFacture = factureRepository.save(facture);
            return mapper.map(savedFacture, FactureDto.class);
        } else {
            throw new FactureExistException("Facture already exists", facture.getNumber());
        }
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
    public FactureDto getFactureByNumber(String number) {
        Facture facture = factureRepository.findByNumber(number)
                .orElseThrow(() -> new ResourceNotFoundException("Facture", "number", Long.parseLong(number)));
        return mapper.map(facture, FactureDto.class);
    }


    @Override
    public FactureDto updateFacture(Long id, FactureDto factureDto) {
        // Vérifier si la facture existe
        Facture facture = factureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facture", "id", id));

        // Mettre à jour les champs de la facture
        mapper.map(factureDto, facture);

        // Vérifier si le champ "etat" est présent dans le DTO et qu'il est valide
        if (factureDto.getEtat() != null) {
            try {
                FactureEtat etat = FactureEtat.valueOf(factureDto.getEtat().name());
                facture.setEtat(etat);
            } catch (IllegalArgumentException e) {
                throw new BadRequestException("Etat de facture invalide: " + factureDto.getEtat());
            }
        }

        // Enregistrer la facture mise à jour
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
            .orElseThrow(() -> new ResourceNotFoundException("client", "id", clientId));

    Set<Facture> factures = client.getFacture();
        return factures.stream().map(facture -> mapper.map(facture, FactureDto.class))
            .collect(Collectors.toList());
}

}
