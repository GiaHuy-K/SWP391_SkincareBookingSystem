package com.seroter.skincare_booking.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Account {
    public long id;


    @Pattern(regexp = "^[A-ZÀ-Ỹ][a-zà-ỹ]+(\s[A-ZÀ-Ỹ][a-zà-ỹ]+){1,}$",message = "Invalid full name!")
    String fullName;


    @Email(message = "Invalid Email")
    String email;

    @Pattern(regexp = "(84|0[3|5|7|8|9]) + (\\d{8})", message = "Invalid phone!")
    String phone;


    @Size(min = 6, message = "Password must be at least 6 character!")
    String password;
}
