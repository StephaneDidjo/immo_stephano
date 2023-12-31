package com.adacorp.immo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public  class Client {
    @Id
    @GeneratedValue
    private UUID clientID;
    private String nomComplet;
    private String email;
}
