package com.example.domaincrawler.controller;

import com.example.commons.model.Domains;
import com.example.domaincrawler.service.DomainCrawlerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DomainCrawlerController {

    private DomainCrawlerService domainCrawlerService;

    public DomainCrawlerController(DomainCrawlerService domainCrawlerService) {
        this.domainCrawlerService = domainCrawlerService;
    }

    @GetMapping("/crawl/{name}")
    public String hello(@PathVariable("name") String name) {
        domainCrawlerService.crawl(name);
        return "Crawled for domain " + name;
    }
}
