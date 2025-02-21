package com.seroter.skincare_booking.service;

import com.seroter.skincare_booking.exception.DuplicateEntity;
import com.seroter.skincare_booking.model.Account;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public Account register(Account account) {
        boolean isDuplicate = false;
        if(isDuplicate){
            throw new DuplicateEntity("Duplicate Entity");
        }else {
            return account;
        }
    }

    public Account login(Account account) {
        return null;
    }
}
