package com.adacorp.immo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProduitRequestDTO {
    private String nomProduit;
    private double prixProduit;
    private double stockProduit;
}
