package com.backEnd.bd.service;

import com.backEnd.bd.entity.Order;
import com.backEnd.bd.entity.Product;
import com.backEnd.bd.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
    public List<Order> getOrder() {
        return orderRepository.findAll();
    }
    public Order getOrderById(long id) {
        return orderRepository.findById(id).orElse(null);
    }

}
