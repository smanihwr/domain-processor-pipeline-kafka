package com.example.domaincrawler.service;

import com.example.commons.model.Domains;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class DomainCrawlerService {

    private DomainFilterService filterService;

    public DomainCrawlerService(DomainFilterService filterService) {
        this.filterService = filterService;
    }

    public void crawl(final String name) {
        Mono<Domains> domainsMono = WebClient.create()
                .get()
                .uri("https://api.domainsdb.info/v1/domains/search?domain=" + name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Domains.class);

        domainsMono.subscribe(domains -> {
            log.info(String.format("Number of domains found for %s is %s", name, domains.getDomains().size()));
            domains.getDomains().forEach(domain -> {
                filterService.filter(domain);
            });
        });
    }
}
