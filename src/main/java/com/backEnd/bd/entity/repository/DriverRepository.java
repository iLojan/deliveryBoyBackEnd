package com.backEnd.bd.entity.repository;

import com.backEnd.bd.entity.Driver;
import com.backEnd.bd.entity.DriverPrices;
import com.backEnd.bd.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<DriverPrices, Long> {
//    List<DriverPrices> findByUserId(Long userId);
}
