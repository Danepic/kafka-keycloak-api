package br.com.danepic.kafkakeycloakapi.service;

import br.com.danepic.kafkakeycloakapi.resource.Specimen;
import br.com.danepic.kafkakeycloakapi.producer.SpecimenProducer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecimenService {

    private static final List<Specimen> REPOSITORY = new ArrayList<>();

    private final SpecimenProducer specimenProducer;

    public SpecimenService(SpecimenProducer specimenProducer) {
        this.specimenProducer = specimenProducer;
    }

    public void sendToConsumerSave(Specimen dto) {
        specimenProducer.sendToConsumerSave(dto);
    }

    public void save(Specimen dto) {
        REPOSITORY.add(dto);
    }

    public List<Specimen> getAll() {
        return REPOSITORY;
    }
}
