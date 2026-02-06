package com.apps.orderservice.service;

import com.apps.orderservice.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static final String TOPIC = "order.created";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessage(Order order) {
        String message = "Order details: "+
                "customer_id: "+order.customer_id()+" "+
                "amount: "+order.amount()+" "+
                "currency: "+order.currency();
        kafkaTemplate.send(TOPIC, message);
        return message;
    }
}
