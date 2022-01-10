package com.example.kafka_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic.name}")
    private String kafka_topic;

    @Value("${kafka.topic.partitions}")
    private Integer kafka_count_partitions;

    @Value("${kafka.topic.replicas}")
    private Integer kafka_count_replicas;

    @Bean
    public NewTopic KafkaTopic() {
        return TopicBuilder
                .name(kafka_topic)
                .partitions(kafka_count_partitions)
                .replicas(kafka_count_replicas)
                .build();
    }

}
