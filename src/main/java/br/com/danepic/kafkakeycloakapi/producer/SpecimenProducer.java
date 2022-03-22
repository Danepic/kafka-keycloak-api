package br.com.danepic.kafkakeycloakapi.producer;

import br.com.danepic.kafkakeycloakapi.resource.Specimen;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecimenProducer {

    private static final List<Specimen> service = new ArrayList<>();

    private final KafkaTemplate<String, Specimen> kafkaTemplate;
    private final String topicName;
    private final ObjectMapper objectMapper;

    public SpecimenProducer(KafkaTemplate<String, Specimen> kafkaTemplate,
                            @Value("${app.events.specimen.topic}") String topicName,
                            ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
        this.objectMapper = objectMapper;
    }

    public void sendToConsumerSave(Specimen dto) {
//        try {
            kafkaTemplate.send(topicName, dto);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
    }
}
