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
    private String information;
    private String status;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDetails sendUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private UserDetails userDetails;



}
