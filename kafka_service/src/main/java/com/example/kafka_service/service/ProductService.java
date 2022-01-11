package com.example.kafka_service.service;

import com.example.kafka_service.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final NewTopic kafkaTopic;

    private final KafkaTemplate<String, Product> kafkaTemplate;

    public void sendMessage(Product product) {
        ListenableFuture<SendResult<String, Product>> future = kafkaTemplate.send(kafkaTopic.name(), UUID.randomUUID().toString(), product);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, Product> result) {
                log.info("Product {} was send", product.toString());
            }

            @Override
            public void onFailure(@NonNull Throwable ex) {
                log.error("Product {} wasn't send. Exception: {}", product.toString(), ex.getMessage());
            }
        });
    }

}
