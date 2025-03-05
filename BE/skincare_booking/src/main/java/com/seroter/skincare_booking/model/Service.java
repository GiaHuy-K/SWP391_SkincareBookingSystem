package com.seroter.skincare_booking.model;

import jakarta.validation.constraints.NotBlank;

public class Service {
    @NotBlank(message = "ServiceId cannot be blank!")
    public String ServiceId;
    @NotBlank(message = "ServiceName cannot be blank!")
    public String ServiceName;
    @NotBlank(message = "Description cannot be blank!")
    public String Description;
    @NotBlank(message = "Price cannot be blank!")
    public String Price;
    @NotBlank(message = "Duration cannot be blank!")
    public String Duration;
}
