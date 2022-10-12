package com.backEnd.bd.repository;


import com.backEnd.bd.entity.Bargain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BargainRepository extends JpaRepository<Bargain, Long> {
    List<Bargain> findByUserId(String id);
    List<Bargain> findByDriverId(long id);
}
