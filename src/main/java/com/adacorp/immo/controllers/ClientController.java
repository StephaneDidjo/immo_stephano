package com.adacorp.immo.controllers;

import com.adacorp.immo.dto.ClientRequestDTO;
import com.adacorp.immo.dto.ClientResponseDTO;
import com.adacorp.immo.exceptions.ClientNotFoundException;
import com.adacorp.immo.models.Client;
import com.adacorp.immo.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clients/")
public class ClientController {
    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("{clientID}")
    public ClientResponseDTO getClientById(@PathVariable("clientID") UUID clientID) throws ClientNotFoundException {

        return clientService.getClientById(clientID);
    }

    @PostMapping("create-client")
    public String createClient(@RequestBody ClientRequestDTO clientAEnregistrer){
        return clientService.createClient(clientAEnregistrer);
    }
    @GetMapping("get-all")
    public List<ClientResponseDTO> getAllClient(){
        return clientService.getAllClient();
    }


    @PutMapping("{clientID}")
    public Client updateClientById(@PathVariable("clientID") UUID clientID,
                                   @RequestBody ClientRequestDTO clientAModifier) throws ClientNotFoundException {
        return clientService.updateClientById(clientID, clientAModifier);
    }
    @DeleteMapping("{clientID}")
    public String deleteClientById(@PathVariable UUID clientID ) throws ClientNotFoundException{
        return clientService.deleteClientById(clientID);
    }
}
