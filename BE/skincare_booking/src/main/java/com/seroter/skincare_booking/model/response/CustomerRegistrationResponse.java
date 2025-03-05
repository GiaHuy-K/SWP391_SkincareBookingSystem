package com.seroter.skincare_booking.model.response;

import com.seroter.skincare_booking.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationResponse {
    public long id;
    public String fullName;
    public String username;
    public String email;
    public RoleEnum roleEnum;
}
