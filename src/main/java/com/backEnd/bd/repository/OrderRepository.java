package com.backEnd.bd.repository;

import com.backEnd.bd.entity.Driver;
import com.backEnd.bd.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
