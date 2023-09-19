package com.adacorp.immo.controllers;

import com.adacorp.immo.models.Client;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clients/")
public class ClientController {
   // Client client1 = new Client("Tyrion Lanister","moneyandpower.com");

    @GetMapping("get-client")
    public String  getClientById(){

        return "Method de retour d'un client";
    }
    @PostMapping("create-client")
    public String createClient(){
        return "Endpoint pour créer un client";
    }
    @PutMapping("edit-client")
    public String editClient(){
        return "Endpoint pour modifier un client";
    }
    @DeleteMapping("delete-client")
    public String deleteClient(){
        return "EndPoint pour delete un client";
    }
}
