package com.backEnd.bd.controller;


import com.backEnd.bd.entity.*;
import com.backEnd.bd.exception.ResourceNotFoundException;
import com.backEnd.bd.payload.DriverSignUpDto;
import com.backEnd.bd.payload.LoginDto;
import com.backEnd.bd.payload.SignUpDto;
import com.backEnd.bd.payload.UserRequest;
import com.backEnd.bd.repository.RoleRepository;
import com.backEnd.bd.repository.UserRepository;
import com.backEnd.bd.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
@Slf4j
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto){
        log.info("return home ===============+++++++++++++++++++");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>(authentication.getName(), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){
       return userService.riderSignUp(signUpDto);
    }

    @PostMapping("/putUser")
    public ResponseEntity<User> updateUser(

            @Valid @RequestBody UserRequest userDetails) throws ResourceNotFoundException {
        log.info("putUser home +++++++++++++++++++");
        User user = userRepository.findById(userDetails.getUser().getId()).orElseThrow(()-> new ResourceNotFoundException("User not found on :: "+ userDetails.getUser().getId()));

        user.setUsername(userDetails.getUser().getUsername());
        user.setName(userDetails.getUser().getName());
        user.setAddress(userDetails.getUser().getAddress());
        user.setFistName(userDetails.getUser().getFistName());
        user.setLastName(userDetails.getUser().getLastName());
        user.setPhoneNumber(userDetails.getUser().getPhoneNumber());
        user.setDriverPrices(userDetails.getUser().getDriverPrices());
        user.setDriverRatings(userDetails.getUser().getDriverRatings());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUserDetails(){
        log.info("findAllUser home +++++++++++++++++++");
        return userService.getAllUser();
    }
    @GetMapping("/getUser/{email}")
    public User findProductByName(@PathVariable String email) {
        log.info("return home 12 +++++++++++++++++++",email);
        return userService.getUserByMail(email);
    }
    @GetMapping("/getUserById/{id}")
    public User findProductById(@PathVariable long id) {
        log.info("return home 12 +++++++++++++++++++",id);
        return userService.getUserById(id);
    }
    @GetMapping("/getUserByRole/{role}")
    public List<User> findUserByRole(@PathVariable String role) {
        log.info("return home 12 +++++++++++++++++++",role);
        return userService.getUserByRole(role);
    }
    @PostMapping("/addRating")
    public DriverRating addRating(@RequestBody DriverRating rating) {
        return userService.saveRating(rating);
    }
    @GetMapping("/getRating/{id}")
    public List<DriverRating> findRatingByUserEmail(@PathVariable long id) {
        return userService.getRatingByUserId(id);
    }
}
