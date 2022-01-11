package com.example.kafka_service.controller;

import com.example.kafka_service.entity.Product;
import com.example.kafka_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    @PutMapping(value = "/add")
    public void sendProduct(@RequestBody Product product){
        productService.sendMessage(product);
    }

}
