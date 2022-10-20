package com.handehdy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableElasticsearchRepositories
public class ElasticServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticServiceApplication.class,args);
    }
}
