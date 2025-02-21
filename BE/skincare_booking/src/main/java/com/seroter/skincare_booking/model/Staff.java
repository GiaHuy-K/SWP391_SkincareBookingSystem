package com.seroter.skincare_booking.model;

import jakarta.validation.constraints.NotBlank;

public class Staff {
    @NotBlank(message = "Staff ID cannot be blank!")
    public String StaffID;
    @NotBlank(message = "Name cannot be blank!")
    public String FullName;
    @NotBlank(message = "Birth date cannot be blank!")
    public String BirthDate;
    @NotBlank(message = "Gender cannot be blank!")
    public String Gender;
    @NotBlank(message = "Phone number cannot be blank!")
    public String PhoneNumber;
    @NotBlank(message = "Email cannot be blank!")
    public String Email;
    @NotBlank(message = "Address cannot be blank!")
    public String Address;
    @NotBlank(message = "Role cannot be blank!")
    public String Role;
    @NotBlank(message = "Work schedule cannot be blank!")
    public String WorkSchedule;
}
