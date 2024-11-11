package com.pablomonteserin.login.persistence.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
    private int id;
    private String text;
    private int remitenteId;
    private int destinatarioId;

    public MessageDTO(int id, String text, int remitenteId, int destinatarioId) {
        this.id = id;
        this.text = text;
        this.remitenteId = remitenteId;
        this.destinatarioId = destinatarioId;
    }
}