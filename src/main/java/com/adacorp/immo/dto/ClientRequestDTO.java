package com.adacorp.immo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientRequestDTO {
    private String nomComplet;
    private String email;
}
