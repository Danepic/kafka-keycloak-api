package br.com.danepic.kafkakeycloakapi.controller;

import br.com.danepic.kafkakeycloakapi.resource.Specimen;
import br.com.danepic.kafkakeycloakapi.service.SpecimenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecimenController {

    private final SpecimenService service;

    public SpecimenController(SpecimenService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public String save(@RequestBody Specimen dto) {
        service.sendToConsumerSave(dto);
        return "Request send!";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Specimen> getAll() {
        return service.getAll();
    }
}
