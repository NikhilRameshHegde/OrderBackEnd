package com.ust.orderservice.controller;

import com.ust.orderservice.model.OrderEntity;
import com.ust.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Create a new order
    @PostMapping
    public OrderEntity createOrder(@RequestBody List<Long> bookIds) {
        return orderService.createOrder(bookIds);
    }

    // Get all orders
    @GetMapping
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Get a specific order by ID
    @GetMapping("/{id}")
    public OrderEntity getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}