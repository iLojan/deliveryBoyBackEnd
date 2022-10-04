package com.backEnd.bd.repository;

import com.backEnd.bd.entity.Driver;
import com.backEnd.bd.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT * FROM order_details pro INNER JOIN users adr ON pro.user_id = adr.id where pro.id = :userId", nativeQuery = true)
    List<Integer> getOrderssByCity(@Param("userId") Integer userId);

//    Optional<Order> findByUserId(String email);
    List<Order> findByUserId(String email);
    List<Order> findByDriverId(long id);
//    Optional<Order> findByUser_Email(String email);
}
