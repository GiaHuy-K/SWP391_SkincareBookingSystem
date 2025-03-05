package com.seroter.skincare_booking.model.request;

import com.seroter.skincare_booking.enums.RoleEnum;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
    @NotBlank(message = "Email cannot be blank!")
    @Email
    public String email;

    @NotBlank(message = "Name cannot be blank!")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only letters and spaces!")
    public String fullName;

    @NotBlank(message = "Phone number cannot be blank!")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits!")
    public String phone;

    @NotBlank(message = "Password cannot be blank!")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must contain only letters and numbers!")
    public String password;

    @NotBlank(message = "Username cannot be blank!")
    public String username;


}
