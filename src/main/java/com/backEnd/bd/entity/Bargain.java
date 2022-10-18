package com.backEnd.bd.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="bargain")
public class Bargain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userId;
    private  long driverId;
    private  long orderId;
    private double price;
    private String hour;
    private String status;
    private String type;


}
