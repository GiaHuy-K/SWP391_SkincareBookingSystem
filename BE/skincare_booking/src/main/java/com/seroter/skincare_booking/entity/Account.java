package com.seroter.skincare_booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {

    @Id  //Kí hiệu khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generate tự động id
    long AccountId;
    String Password;
    String Role;
    String Name;
    String Email;
    String PhoneNumber;
    String Address;
    String Birthday;
    String Gender;
}
