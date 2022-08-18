package com.backEnd.bd.controller;

import com.backEnd.bd.entity.DriverPrices;
import com.backEnd.bd.entity.Order;
import com.backEnd.bd.entity.Product;
import com.backEnd.bd.exception.ResourceNotFoundException;
import com.backEnd.bd.repository.DriverRepository;
import com.backEnd.bd.repository.UserRepository;
import com.backEnd.bd.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/addOrder")
    public Order addProduct(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/orders")
    public List<Order> findAllOrder() {
        return orderService.getOrder();
    }

    @GetMapping("/price")
    public List<DriverPrices> findAllPrice() {
        return orderService.getDriverPrices();
    }

//    @PostMapping("/posts/{postId}/comments")
//    public DriverPrices createComment(@PathVariable (value = "postId") Long postId,
//                                 @Valid @RequestBody DriverPrices driverPrices) {
//        return userRepository.findById(postId).map(user -> {
//            driverPrices.setUser(user);
//            return driverRepository.save(driverPrices);
//        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
//    }

    @GetMapping("/orderById/{id}")
    public Order findOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }
//    @GetMapping("/posts/{id}/comments")
//    public List<DriverPrices> getAllCommentsByPostId(@PathVariable int id) {
//        return orderService.getPriceById(id);
//    }
    @GetMapping("/orderByEmail/{email}")
    public List<Order> findOrderByUserEmail(@PathVariable String email) {
        return orderService.getOrderByUserMail(email);
    }


}
