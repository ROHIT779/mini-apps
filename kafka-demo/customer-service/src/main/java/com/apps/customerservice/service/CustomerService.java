package com.apps.customerservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @KafkaListener(topics = "order.created", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Message received: " + message);
    }
}
