package com.backEnd.bd.service;

import com.backEnd.bd.entity.DriverPrices;
import com.backEnd.bd.entity.Order;
import com.backEnd.bd.entity.repository.DriverRepository;
import com.backEnd.bd.entity.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DriverRepository driverRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrder() {
        return orderRepository.findAll();
    }
    public List<DriverPrices> getDriverPrices() {
        return driverRepository.findAll();
    }
    public Order getOrderById(long id) {
        return orderRepository.findById(id).orElse(null);
    }

//    public List<DriverPrices> getPriceById(long id) {
//        return driverRepository.findByUserId(id);
//    }

    public List<Integer> getOrderByUser(Integer userId) {
        log.info("return home +++++++++++++++++++",userId);
        return orderRepository.getOrderssByCity(userId);
    }
    public List<Order> getOrderByUserMail(String email){
        return orderRepository.findByUserId(email);
    }
    public List<Order> getOrderByDriverId(long id){
        return orderRepository.findByDriverId(id);
    }



}
