package br.com.danepic.kafkakeycloakapi.resource;

import br.com.danepic.kafkakeycloakapi.resource.type.SpecimenStatus;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Specimen {
    private String resourceType;
    private String id;
    private Text text;
    private List<Contained> contained;
    private List<Identifier> identifier;
    private Identifier accessionIdentifier;
    @NotBlank
    private SpecimenStatus status;
    private CodeableConcept type;
    private Reference subject;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime receivedTime;
    private List<Reference> parent;
    private List<Reference> request;
    private Collection collection;
    private Processing processing;
    private Container container;
    private CodeableConcept condition;
    private List<Note> note;
}
