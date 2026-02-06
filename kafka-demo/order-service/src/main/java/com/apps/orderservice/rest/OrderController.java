package com.apps.orderservice.rest;

import com.apps.orderservice.model.Order;
import com.apps.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService service){
        this.orderService = service;
    }

    @PostMapping("")
    public ResponseEntity<String> createOrder(@RequestBody Order order){
        String response = orderService.sendMessage(order);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(201));
    }
}
