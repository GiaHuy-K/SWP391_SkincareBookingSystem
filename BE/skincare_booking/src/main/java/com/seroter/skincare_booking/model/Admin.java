package com.seroter.skincare_booking.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Admin {
    @NotBlank(message = "Admin ID cannot be blank!")
    public String AdminID;
    @NotBlank(message = "Username cannot be blank!")
    public String Username;
    @NotBlank(message = "Password cannot be blank!")
    public String Password;
    @NotBlank(message = "FullName cannot be blank!")
    public String FullName;
    @NotBlank(message = "PhoneNumber cannot be blank!")
    public String PhoneNumber;
    @NotBlank(message = "Email cannot be blank!")
    public String Email;

}
