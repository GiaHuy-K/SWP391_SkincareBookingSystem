package com.seroter.skincare_booking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng ID
    private Long id;
    @NotBlank(message = "Name cannot be blank!")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only letters and spaces!")
    public String name;
    @NotBlank(message = "Birth date cannot be blank!")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Birth date must be in the format yyyy-MM-dd!")
    public String birthDate;
    @NotBlank(message = "Gender cannot be blank!")
    @Pattern(regexp = "^(male|female)$", message = "Gender must be either male or female!")
    public String gender;
    @NotBlank(message = "Phone number cannot be blank!")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits!")
    public String phoneNumber;
    @NotBlank(message = "Email cannot be blank!")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email address!")
    public String email;
    @NotBlank(message = "Address cannot be blank!")
    public String address;
    @NotBlank(message = "Skin type cannot be blank!")
    public String skinType;
    public String bookingHistory;

    public boolean isDeleted = false;
}
