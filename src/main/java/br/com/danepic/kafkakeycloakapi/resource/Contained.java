package br.com.danepic.kafkakeycloakapi.resource;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class Contained {
    private String resourceType;
    private String id;
    private Identifier accessionIdentifier;
    private String status;
    private CodeableConcept type;
    private Reference subject;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime receivedTime;
    private Collection collection;
    private CodeableConcept code;
}
