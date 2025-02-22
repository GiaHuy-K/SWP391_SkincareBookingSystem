package com.seroter.skincare_booking.service;

import com.seroter.skincare_booking.entity.Account;
import com.seroter.skincare_booking.exception.DuplicateEntity;

import com.seroter.skincare_booking.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    AuthenticationRepository authenticationRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Account register(Account account) {
        //Xử lý logic

        //lưu xuống database

        Account newAccount = authenticationRepository.save(account);
        return newAccount;
    }

    public Account login(Account account) {
        return null;
    }
}
