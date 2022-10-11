package com.backEnd.bd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="order_details")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String material;
    private String weight;
    private double distance;
    private double total;
    private double price;
    private double standardPrice;
    private double driverExtraPrice;
    private String duration;
    private String information;
    private String status;
    private String fromLocation;
    private String toLocation;
    private String receiverName;
    private String receiverEmail;
    private String receiverPhoneNumber;
    private String userId;
    private  long driverId;
    private String createdAt;
    private String updatedAt;
    private double driverAdditionalCharge;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private User user;

//    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
//    @JoinColumn(name ="cp_fk",referencedColumnName = "id")
//    private List<User> user;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private UserDetails sendUser;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "driver_id", referencedColumnName = "id")
//    private UserDetails userDetails;



}
