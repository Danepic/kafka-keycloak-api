package br.com.danepic.kafkakeycloakapi.consumer;

import br.com.danepic.kafkakeycloakapi.resource.Specimen;
import br.com.danepic.kafkakeycloakapi.service.SpecimenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpecimenConsumer {

    private final SpecimenService specimenService;

    private final ObjectMapper objectMapper;

    public SpecimenConsumer(SpecimenService specimenService, ObjectMapper objectMapper) {
        this.specimenService = specimenService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "${app.events.specimen.topic}", groupId = "${app.events.specimen.groupId}")
    public void save(@Payload Specimen dto) {
        log.info("Message received...");
        specimenService.save(dto);
    }

}
