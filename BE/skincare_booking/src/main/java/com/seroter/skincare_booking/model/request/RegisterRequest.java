package com.seroter.skincare_booking.model.request;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

// Lớp RegisterRequest
@Data
public class RegisterRequest {
    @NotBlank(message = "Code cannot be blank!")
    @Pattern(regexp = "[A-Z]{1}[0-9]{6}", message = "Invalid code!")
    @Column(unique = true)
    private String code;

    @Email(message = "Invalid Email!")
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "(84|0[3|5|7|8|9])([0-9]{8})", message = "Invalid phone!")
    @Column(unique = true)
    private String phone;

    @Size(min = 6, message = "Password must be at least 6 characters!")
    private String password;

    private Role role; // Sử dụng enum Role để biểu thị vai trò
}
