package com.adacorp.immo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

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
    private Integer clientID;
private String nomComplet;
private String email;
}
