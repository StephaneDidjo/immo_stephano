package com.adacorp.immo.controllers;

import com.adacorp.immo.dto.ProduitRequestDTO;
import com.adacorp.immo.models.Produit;
import com.adacorp.immo.services.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/produits/")
public class ProduitController {
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }
    @GetMapping("{produitID}")
    public Optional<Produit> getProduitByID(@PathVariable("produitID") UUID produitID){
        return produitService.getProduitByID(produitID);
    }

    @PostMapping("créer-produit")
    public String createProduit(@RequestBody ProduitRequestDTO produitAEnregistrer){
        return produitService.createProduit(produitAEnregistrer);
    }
}
