package com.example.domainprocessor;

import com.example.commons.model.Domain;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@Slf4j
public class DomainKafkaProcessor {

    @Bean
    public Function<KStream<String, Domain>, KStream<String, Domain>> domainProcessor () {
        return kStream -> kStream.filter(((key, domain) -> {
//            if(!domain.isDead()) {
            if(domain.getDomain().length() == 15) {
                log.info("Active " + domain.getDomain());
            } else {
                log.info("Dead " + domain.getDomain());
            }
//            return !domain.isDead();

            return (domain.getDomain().length() == 15);
        }));
    }
}
