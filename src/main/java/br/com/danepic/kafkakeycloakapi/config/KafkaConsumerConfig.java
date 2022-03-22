package br.com.danepic.kafkakeycloakapi.config;

import br.com.danepic.kafkakeycloakapi.resource.Specimen;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    private final String BOOTSTRAP_ADDRESS;
    private final String GROUP_ID;

    public KafkaConsumerConfig(@Value("${kafka.bootstrapAddress}") String bootstrapAddress,
                               @Value("${app.events.specimen.groupId}") String groupId) {
        BOOTSTRAP_ADDRESS = bootstrapAddress;
        GROUP_ID = groupId;
    }

    @Bean
    public ConsumerFactory<String, Specimen> consumerFactory() {
        JsonDeserializer<Specimen> deserializer = new JsonDeserializer<>(Specimen.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_ADDRESS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Specimen> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Specimen> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
