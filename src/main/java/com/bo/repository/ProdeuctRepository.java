package com.bo.repository;

import com.bo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdeuctRepository extends JpaRepository<Product,Integer> {

Product findByName(String name);
}
