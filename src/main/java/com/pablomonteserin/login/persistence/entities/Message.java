package com.pablomonteserin.login.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    @ManyToOne
    private User remitente;
    @ManyToOne
    private User destinatarios;

}
