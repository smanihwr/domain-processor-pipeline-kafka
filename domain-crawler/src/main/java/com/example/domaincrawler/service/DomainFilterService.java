package com.example.domaincrawler.service;

import com.example.commons.model.Domain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
@Slf4j
public class DomainFilterService {

    private KafkaTemplate<String, Domain> kafkaTemplate;
    private final String WEB_DOMAINS_TOPIC = "web-domains";

    public DomainFilterService(KafkaTemplate<String, Domain> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void filter(Domain domain) {
        ListenableFuture<SendResult<String, Domain>> future = kafkaTemplate.send(WEB_DOMAINS_TOPIC, domain);
    }
}
