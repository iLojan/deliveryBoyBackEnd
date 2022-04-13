package com.backEnd.bd.entity;

import lombok.Data;

import javax.persistence.*;

@Data@Entity
@Table(name="userDetails")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String fistName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String username;
    private String email;
    private String address;

    @OneToOne(mappedBy = "sendUser")
    private Order orderUser;

    @OneToOne(mappedBy = "userDetails")
    private Order order;





    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user123;

}
