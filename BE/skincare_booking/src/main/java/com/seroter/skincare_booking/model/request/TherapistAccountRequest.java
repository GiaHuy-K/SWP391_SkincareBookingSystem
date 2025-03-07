package com.seroter.skincare_booking.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TherapistAccountRequest {
    @Email
    String email;

    @NotBlank(message = "Name cannot be blank!")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only letters and spaces!")
    String fullName;

    @NotBlank(message = "Phone number cannot be blank!")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits!")
    String phone;

    @NotBlank(message = "Password cannot be blank!")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must contain only letters and numbers!")
    String password;

    @NotBlank(message = "Qualification cannot be blank!")
    String qualification;

    int experience;

    @NotBlank(message = "Username cannot be blank!")
    String username;

    Set<Long> skinCareServiceIds;
}
