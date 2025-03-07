package com.seroter.skincare_booking.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.seroter.skincare_booking.enums.RoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generate id
    public long id;

    @Column(unique = true)
    public String email;

    public String fullName;

    @Column(unique = true)
    public String phone;

    public String password;

    @Column(unique = true)
    public String username;

    @Enumerated(value = EnumType.STRING)// lưu số manager,customer,...
    public RoleEnum roleEnum;

    public String qualification;

    public int experience;

    public Account() {

    }


    public Account(long id, String email, String fullName, String phone, String password, String username, RoleEnum roleEnum, String qualification, int experience) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.password = password;
        this.username = username;
        this.roleEnum = roleEnum;
        this.qualification = qualification;
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    @Override
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@class")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = SimpleGrantedAuthority.class, name = "SimpleGrantedAuthority")
    })
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(this.roleEnum.toString()));
        return authorities;
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

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }


    @ManyToMany
    @JoinTable(name = "therapist_services" ,
            joinColumns = @JoinColumn(name = "therapist_id"),
            inverseJoinColumns = @JoinColumn(name = "skincare_service_id"))
    private Set<SkincareService> skincareServices;

    @OneToMany(mappedBy = "customer")
    private Set<Booking> bookings;

    @OneToMany(mappedBy = "therapist")
    private Set<Booking> assignedTherapist;


    @OneToMany(mappedBy="staff")
    private Set<Booking> assignedStaff;

}
