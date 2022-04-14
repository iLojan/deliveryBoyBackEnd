package com.backEnd.bd.controller;

import com.backEnd.bd.entity.Order;
import com.backEnd.bd.entity.Product;
import com.backEnd.bd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/addOrder")
    public Order addProduct(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/orders")
    public List<Order> findAllOrder() {
        return orderService.getOrder();
    }
}
