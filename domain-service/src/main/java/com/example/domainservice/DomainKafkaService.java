package com.example.domainservice;

import com.example.commons.model.Domain;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class DomainKafkaService {

    @Bean
    public Consumer<KStream<String, Domain>> domainService() {
        return kstream -> kstream.foreach( (key, domain) -> log.info("Active " +domain.getDomain()));
    }
}
