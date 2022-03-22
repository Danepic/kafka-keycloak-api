package br.com.danepic.kafkakeycloakapi.resource;

import lombok.Data;

import java.util.List;

@Data
public class CodeableConcept {
    private List<Coding> coding;
    private String text;
}
