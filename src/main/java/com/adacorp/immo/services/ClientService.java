package com.adacorp.immo.services;

import com.adacorp.immo.dto.ClientRequestDTO;
import com.adacorp.immo.dto.ClientResponseDTO;
import com.adacorp.immo.exceptions.ClientNotFoundException;
import com.adacorp.immo.models.Client;
import com.adacorp.immo.repositories.ClientRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public ClientResponseDTO getClientById(UUID clientID) throws ClientNotFoundException {
        Client cl1 = clientRepository.findById(clientID)
                .orElseThrow(()-> new ClientNotFoundException("Client avec l'id "+ clientID+" introuvable"));

        ClientResponseDTO cl1DTO = new ClientResponseDTO().builder()
                .nomComplet(cl1.getNomComplet())
                .email(cl1.getEmail())
                .build();
        return cl1DTO;
              }

    public String createClient(ClientRequestDTO clientAEnregistrer) {
        Client cl1 = new Client();
        cl1.setNomComplet(clientAEnregistrer.getNomComplet());
        cl1.setEmail(clientAEnregistrer.getEmail());

        Client saved = clientRepository.save(cl1);
        return "Client enregistré avec succès " + saved;
    }

    public List<ClientResponseDTO> getAllClient() {
        // Recuperation de la liste des clients dans une liste
        List<Client> clientList = clientRepository.findAll();
        //Creation d'une liste de clientDTO vide
        List<ClientResponseDTO> clientResponseDTOList = new ArrayList<>();
       // conversion des clients classiques en clientDTO
        for (Client client: clientList ) {
            ClientResponseDTO clientResponseDTO = new ClientResponseDTO().builder()
                    .nomComplet(client.getNomComplet())
                    .email(client.getEmail())
                    .build();
            clientResponseDTOList.add(clientResponseDTO);
        }
        return clientResponseDTOList;
    }

    public Client updateClientById(UUID clientID, ClientRequestDTO donneesClient) throws ClientNotFoundException {
    Client clientAModifier = clientRepository.findById(clientID)
            .orElseThrow(() -> new ClientNotFoundException(" Client avec ID "+ clientID+
                    " introuvable") );
        clientAModifier.setNomComplet(donneesClient.getNomComplet());
        clientAModifier.setEmail(donneesClient.getEmail());
        return clientRepository.save(clientAModifier);
    }

    public String deleteClientById(UUID clientID) throws ClientNotFoundException {
    Client clientASupprimer = clientRepository.findById(clientID)
            .orElseThrow(() -> new ClientNotFoundException("Client avec ID "+ clientID+
                    " introuvable"));
        clientRepository.delete(clientASupprimer);
        return "client avec l'id "+ clientID+" supprimé avec succès";
    }
}

