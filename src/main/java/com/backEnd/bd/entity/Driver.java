package com.backEnd.bd.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="driver")
public class Driver {


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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;
}
