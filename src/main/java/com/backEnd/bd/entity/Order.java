package com.backEnd.bd.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="order_details")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String material;
    private String weight;
    private double distance  ;
    private double price;
    private String duration;
    private String information;
    private String status;
    private String fromLocation;
    private String toLocation;
    private String receiverName;
    private String receiverEmail;
    private String receiverPhoneNumber;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDetails sendUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private UserDetails userDetails;



}
