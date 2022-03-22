package br.com.danepic.kafkakeycloakapi.resource;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Processing {
    private String description;
    private CodeableConcept procedure;
    private List<Reference> additive; //talvez objeto proprio
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime timeDateTime;
    private Period timePeriod;
}
