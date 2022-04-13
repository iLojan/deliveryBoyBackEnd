package com.backEnd.bd.payload;

import lombok.Data;

@Data
public class DriverSignUpDto {
    private String fistName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String address;
    private String username;
    private String email;
    private String role;
}
