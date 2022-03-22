package br.com.danepic.kafkakeycloakapi.resource;

import lombok.Data;

@Data
public class Coding {
    private String system;
    private String version;
    private String code;
    private String display;
    private boolean userSelected;
}
