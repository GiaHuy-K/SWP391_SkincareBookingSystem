package com.seroter.skincare_booking.model.request;


import com.seroter.skincare_booking.enums.RoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class LoginRequest {
    @NotBlank(message = "Email cannot be blank!")
    @Email(message = "Invalid email format!")
    private String email;

    @NotBlank(message = "Password cannot be blank!")
    @Size(min = 6, message = "Password must be at least 6 characters!")
    private String password;

    private RoleEnum role; // Sử dụng enum Role đã định nghĩa riêng
}

