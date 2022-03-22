package br.com.danepic.kafkakeycloakapi.resource;

import lombok.Data;

import java.util.List;

@Data
public class Container {
    private List<Identifier> identifier;
    private String description;
    private CodeableConcept type;
    private QuantityUnit capacity;
    private QuantityUnit specimenQuantity;
    private CodeableConcept additiveCodeableConcept;
    private Reference additiveReference;
}
