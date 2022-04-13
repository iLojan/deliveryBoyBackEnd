package com.backEnd.bd.service;

import com.backEnd.bd.entity.Driver;
import com.backEnd.bd.entity.Product;
import com.backEnd.bd.entity.Role;
import com.backEnd.bd.entity.User;
import com.backEnd.bd.payload.DriverSignUpDto;
import com.backEnd.bd.payload.SignUpDto;
import com.backEnd.bd.repository.DriverRepository;
import com.backEnd.bd.repository.RoleRepository;
import com.backEnd.bd.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public ResponseEntity<?> riderSignUp(SignUpDto signUpDto) {
        // add check for username exists in a DB
        if(userRepository.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
//        ROLE_ADMIN
        Role roles = roleRepository.findByName(signUpDto.getRole()).get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
    public ResponseEntity<?> driverSignUp(DriverSignUpDto driverSignUpDto) {
        // add check for username exists in a DB
        if(driverRepository.existsByUsername(driverSignUpDto.getUsername())){
            return new ResponseEntity("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(driverRepository.existsByEmail(driverSignUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        Driver driver = new Driver();

        driver.setFistName(driverSignUpDto.getFistName());
        driver.setLastName(driverSignUpDto.getLastName());
        driver.setUsername(driverSignUpDto.getUsername());
        driver.setPhoneNumber(driverSignUpDto.getPhoneNumber());
        driver.setAddress(driverSignUpDto.getAddress());
        driver.setEmail(driverSignUpDto.getEmail());
        driver.setPassword(passwordEncoder.encode(driverSignUpDto.getPassword()));
        Role roles = roleRepository.findByName(driverSignUpDto.getRole()).get();
        driver.setRoles(Collections.singleton(roles));
        // create user object


        driverRepository.save(driver);

        return new ResponseEntity<>("Driver registered successfully", HttpStatus.OK);
    }

    public User getUserByMail(String email) {
        log.info("return home ===============+++++++++++++++++++",email);
        return userRepository.findByEmail(email);
    }
    public List<User>getAllUser(){
        log.info("getAllUser home ===============+++++++++++++++++++");
        return userRepository.findAll();
    }
}
