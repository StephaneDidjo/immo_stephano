package com.adacorp.immo.services;

import com.adacorp.immo.dto.ProduitRequestDTO;
import com.adacorp.immo.models.Produit;
import com.adacorp.immo.repositories.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProduitService {
    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Optional<Produit> getProduitByID(UUID produitID) {
        return produitRepository.findById(produitID);
    }

    public String createProduit(ProduitRequestDTO produitAEnregistrer) {
        Produit pd1 = new Produit();
        pd1.setNomProduit(produitAEnregistrer.getNomProduit());
        pd1.setPrixProduit(produitAEnregistrer.getPrixProduit());
        pd1.setStockProduit(produitAEnregistrer.getStockProduit());

        Produit saved = produitRepository.save(pd1);
        return " Produit avec enregistrer avec succès "+ saved;
    }
}
