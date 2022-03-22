package br.com.danepic.kafkakeycloakapi.resource;

import lombok.Data;

@Data
public class Reference {
    private String reference;
    private String display;
    private String type;
    private Identifier identifier;
}
