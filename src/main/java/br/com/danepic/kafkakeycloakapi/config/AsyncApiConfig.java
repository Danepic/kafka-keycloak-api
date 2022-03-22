package br.com.danepic.kafkakeycloakapi.config;

import br.com.danepic.kafkakeycloakapi.resource.Specimen;
import com.asyncapi.v2.binding.kafka.KafkaOperationBinding;
import com.asyncapi.v2.model.info.Info;
import com.asyncapi.v2.model.server.Server;
import io.github.stavshamir.springwolf.asyncapi.types.ProducerData;
import io.github.stavshamir.springwolf.configuration.AsyncApiDocket;
import io.github.stavshamir.springwolf.configuration.EnableAsyncApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@EnableAsyncApi
public class AsyncApiConfig {

    private final String BOOTSTRAP_SERVERS;
    private final String CONSUMERS_BASE_PACKAGE;

    private final String SPECIMEN_TOPIC;

    public AsyncApiConfig(@Value("${kafka.bootstrapAddress}") String bootstrapServers,
                          @Value("${app.events.consumers.package}") String consumersBasePackage,
                          @Value("${app.events.specimen.topic}") String specimenTopic) {
        this.BOOTSTRAP_SERVERS = bootstrapServers;
        this.CONSUMERS_BASE_PACKAGE = consumersBasePackage;
        this.SPECIMEN_TOPIC = specimenTopic;
    }

    @Bean
    public AsyncApiDocket asyncApiDocket() {
        Info info = Info.builder()
                .version("1.0.0")
                .title("Springwolf example project")
                .build();

        Server kafkaServer = Server.builder()
                .protocol("kafka")
                .url(BOOTSTRAP_SERVERS)
                .build();

        ProducerData exampleProducerData = ProducerData.builder()
                .channelName(SPECIMEN_TOPIC)
                .binding(Map.of("kafka", new KafkaOperationBinding()))
                .payloadType(Specimen.class)
                .build();

        return AsyncApiDocket.builder()
                .basePackage(CONSUMERS_BASE_PACKAGE)
                .info(info)
                .server("kafka", kafkaServer)
                .build();
    }
}
