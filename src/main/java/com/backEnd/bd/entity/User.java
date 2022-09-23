package com.backEnd.bd.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String fistName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String roles;
    private String test;

    @OneToOne(targetEntity = DriverPrices.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="cp_fk",referencedColumnName = "id")
    private DriverPrices driverPrices ;

    @OneToMany(targetEntity = DriverRating.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="rating_fk",referencedColumnName = "id")
    private List<DriverRating> driverRatings;

}