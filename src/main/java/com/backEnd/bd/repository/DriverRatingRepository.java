package com.backEnd.bd.repository;

import com.backEnd.bd.entity.DriverRating;
import com.backEnd.bd.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRatingRepository extends JpaRepository<DriverRating, Long> {
    List<DriverRating> findByUserId(long id);
}
