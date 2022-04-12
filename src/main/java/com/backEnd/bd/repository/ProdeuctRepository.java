package com.backEnd.bd.repository;

import com.backEnd.bd.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdeuctRepository extends JpaRepository<Product,Integer> {

Product findByName(String name);
}
