package com.backEnd.bd.service;

import com.backEnd.bd.entity.Order;
import com.backEnd.bd.entity.Product;
import com.backEnd.bd.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
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
    public List<Integer> getOrderByUser(Integer userId) {
        log.info("return home +++++++++++++++++++",userId);
        return orderRepository.getOrderssByCity(userId);
    }
    public List<Order> getOrderByUserMail(String email){
        return orderRepository.findByUserId(email);
    }

}
