package com.example.mongo_service.service;

import com.example.mongo_service.entity.Product;
import com.example.mongo_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.topic.group_id}", containerFactory = "kafkaListenerContainerFactory")
    public void getMessage(Product product) {
        save(product);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

}
