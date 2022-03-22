package br.com.danepic.kafkakeycloakapi.resource;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class Collection {
    private Reference collector;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime collectedDateTime;
    private Period period;
    private QuantityUnit quantity;
    private CodeableConcept method;
    private CodeableConcept bodySite;
    private CodeableConcept fastingStatusCodeableConcept;
}
