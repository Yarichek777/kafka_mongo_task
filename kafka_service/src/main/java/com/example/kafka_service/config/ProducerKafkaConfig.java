package com.example.kafka_service.config;

import com.example.kafka_service.entity.Product;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@EnableKafka
public class ProducerKafkaConfig {

    @Bean
    public ProducerFactory<String, Product> producerFactory(KafkaProperties properties) {
        return new DefaultKafkaProducerFactory<>(properties.buildProducerProperties());
    }

    @Bean
    public KafkaTemplate<String, Product> kafkaTemplate(ProducerFactory<String, Product> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

}
