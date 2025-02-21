package com.seroter.skincare_booking.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Account {
    @NotBlank(message = "Account ID cannot be blank!")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Account ID must contain only letters and numbers!")
    public String AccountID;
    @NotBlank(message = "Password cannot be blank!")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must contain only letters and numbers!")
    public String Password;
    @NotBlank(message = "Role cannot be blank!")
    @Pattern(regexp = "^(admin|staff|customer)$", message = "Role must be either admin, staff or customer!")
    public String Role;
    @NotBlank(message = "Name cannot be blank!")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only letters and spaces!")
    public String Name;
    @NotBlank(message = "Email cannot be blank!")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email address!")
    public String Email;
    @NotBlank(message = "Phone number cannot be blank!")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits!")
    public String PhoneNumber;
    @NotBlank(message = "Address cannot be blank!")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Address must contain only letters and spaces!")
    public String Address;
    @NotBlank(message = "Birth date cannot be blank!")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Birth date must be in the format yyyy-MM-dd!")
    public String BirthDate;
    @NotBlank(message = "Gender cannot be blank!")
    @Pattern(regexp = "^(male|female)$", message = "Gender must be either male or female!")
    public String Gender;

}
