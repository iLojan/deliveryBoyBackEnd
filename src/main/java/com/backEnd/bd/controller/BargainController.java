package com.backEnd.bd.controller;


import com.backEnd.bd.entity.Bargain;
import com.backEnd.bd.entity.Order;
import com.backEnd.bd.exception.ResourceNotFoundException;
import com.backEnd.bd.repository.BargainRepository;
import com.backEnd.bd.service.BargainService;
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
public class BargainController {

    @Autowired
    private BargainService bargainService;

    @Autowired
    private BargainRepository bargainRepository;

    @PostMapping("/addBargain")
    public Bargain addBargain(@RequestBody Bargain bargain) {
        return bargainService.saveBargain(bargain);
    }

    @PostMapping("/updateBargain")
    public ResponseEntity<Bargain> updateUser(
            @Valid @RequestBody Bargain bargainDetails) throws ResourceNotFoundException {

        Bargain bargain  = bargainRepository.findById(bargainDetails.getId()).orElseThrow(()-> new ResourceNotFoundException("User not found on :: "+ bargainDetails.getId()));

        bargain.setPrice(bargainDetails.getPrice());
        bargain.setHour(bargainDetails.getHour());

        final Bargain bargainUpadte = bargainRepository.save(bargain);
        return ResponseEntity.ok(bargainUpadte);
    }

    @PostMapping("/updateBargainStatus")
    public ResponseEntity<Bargain> updateBargainStatus(
            @Valid @RequestBody Bargain bargainDetails) throws ResourceNotFoundException {

        Bargain bargain  = bargainRepository.findById(bargainDetails.getId()).orElseThrow(()-> new ResourceNotFoundException("User not found on :: "+ bargainDetails.getId()));
        bargain.setStatus(bargainDetails.getStatus());

        final Bargain bargainUpadte = bargainRepository.save(bargain);
        return ResponseEntity.ok(bargainUpadte);
    }

    @GetMapping("/bargainByUserId/{id}")
    public List<Bargain> findBargainByUserId(@PathVariable String id) {
        return bargainService.getBargainByUserId(id);
    }

    @GetMapping("/bargainByDriverId/{id}")
    public List<Bargain> findBargainByDriverId(@PathVariable long id) {
        return bargainService.getBargainByDriverId(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        return bargainService.deleteBargain(id);
    }
}
