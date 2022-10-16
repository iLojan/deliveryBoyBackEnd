package com.backEnd.bd.service;

import com.backEnd.bd.entity.Bargain;
import com.backEnd.bd.entity.repository.BargainRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BargainService {

    @Autowired
    BargainRepository bargainRepository;

    public Bargain saveBargain(Bargain bargain) {
        return bargainRepository.save(bargain);
    }
    public Bargain getBargainId(long id) {
        return bargainRepository.findById(id).orElse(null);
    }
    public List<Bargain> getBargainByUserId(String id) {
        return bargainRepository.findByUserId(id);
    }

    public String deleteBargain(long id) {
        bargainRepository.deleteById(id);
        return "product removed !! " + id;
    }
    public List<Bargain> getBargainByDriverId(long id) {
        return bargainRepository.findByDriverId(id);
    }
}
