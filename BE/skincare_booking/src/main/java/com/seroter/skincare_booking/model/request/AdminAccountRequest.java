package com.seroter.skincare_booking.model.request;

import com.seroter.skincare_booking.enums.RoleEnum;
import jakarta.persistence.Column;

public class AdminAccountRequest {
    public String email;

    public String fullName;

    public String phone;

    public String password;



    @Column(unique = true)
    public String username;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
