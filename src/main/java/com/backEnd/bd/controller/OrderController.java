package com.backEnd.bd.controller;

import com.backEnd.bd.entity.DriverPrices;
import com.backEnd.bd.entity.Order;
import com.backEnd.bd.exception.ResourceNotFoundException;
import com.backEnd.bd.payload.OrderRequest;
import com.backEnd.bd.repository.DriverRepository;
import com.backEnd.bd.repository.OrderRepository;
import com.backEnd.bd.repository.UserRepository;
import com.backEnd.bd.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;
    @PostMapping("/addOrder")
    public Order addProduct(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @PostMapping("/updateOrder")
    public ResponseEntity<Order> updateUser(
            @Valid @RequestBody Order orderDetails) throws ResourceNotFoundException {

        Order order  = orderRepository.findById(orderDetails.getId()).orElseThrow(()-> new ResourceNotFoundException("User not found on :: "+ orderDetails.getId()));

        order.setReceiverName(orderDetails.getReceiverName());
        order.setMaterial(orderDetails.getMaterial());
        order.setWeight(orderDetails.getWeight());
        order.setDistance(orderDetails.getDistance());
        order.setTotal(orderDetails.getTotal());
        order.setStandardPrice(orderDetails.getStandardPrice());
        order.setStandardPrice(orderDetails.getStandardPrice());
        order.setDriverExtraPrice(orderDetails.getDriverExtraPrice());
        order.setDuration(orderDetails.getDuration());
        order.setInformation(orderDetails.getInformation());
        order.setStatus(orderDetails.getStatus());
        order.setFromLocation(orderDetails.getFromLocation());
        order.setToLocation(orderDetails.getToLocation());
        order.setReceiverEmail(orderDetails.getReceiverEmail());
        order.setReceiverPhoneNumber(orderDetails.getReceiverPhoneNumber());
        order.setDriverId(orderDetails.getDriverId());
        order.setUpdatedAt(orderDetails.getUpdatedAt());

        final Order updatedUser = orderRepository.save(order);
        return ResponseEntity.ok(updatedUser);
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
    @GetMapping("/orderDriverId/{id}")
    public List<Order> findOrderByDriverId(@PathVariable long id) {
        return orderService.getOrderByDriverId(id);
    }
    @PostMapping("/updateStatus")
    public ResponseEntity<Order> updateUser(

            @Valid @RequestBody OrderRequest orderRequest) throws ResourceNotFoundException {
        log.info("putUser home +++++++++++++++++++");
        Order order = orderRepository.findById(orderRequest.getId()).orElseThrow(()-> new ResourceNotFoundException("order not found on :: "+ orderRequest.getId()));

        order.setStatus(orderRequest.getStatus());

        final Order updatedOrder = orderRepository.save(order);
        return ResponseEntity.ok(updatedOrder);
    }


}
