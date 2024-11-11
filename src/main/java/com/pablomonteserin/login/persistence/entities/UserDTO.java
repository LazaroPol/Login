package com.pablomonteserin.login.persistence.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int id;
    private String username; // Ajusta esto según los atributos de la entidad User

    // Constructor
    public UserDTO(int id, String username) {
        this.id = id;
        this.username = username;
    }
}