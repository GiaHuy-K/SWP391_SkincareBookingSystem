package com.seroter.skincare_booking.service;

import com.seroter.skincare_booking.entity.Account;
import com.seroter.skincare_booking.enums.RoleEnum;
import com.seroter.skincare_booking.model.request.AccountRequest;
import com.seroter.skincare_booking.model.request.AdminAccountRequest;
import com.seroter.skincare_booking.model.request.StaffAccountRequest;
import com.seroter.skincare_booking.model.request.TherapistAccountRequest;
import com.seroter.skincare_booking.repository.AuthenticationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationRepository authenticationRepository;


    public Account register( AdminAccountRequest accountRequest) {

        Account account = new Account();
        account.setUsername(accountRequest.getUsername());
        account.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
        account.setFullName(accountRequest.getFullName());
        account.setEmail(accountRequest.getEmail());
        account.setPhone(accountRequest.getPhone());
        account.setRoleEnum(RoleEnum.ADMIN);
        Account newAccount = authenticationRepository.save(account);
        return newAccount;
    }

    public Account registerTherapist(TherapistAccountRequest accountRequest) {

        Account account = new Account();
        account.setUsername(accountRequest.getUsername());
        account.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
        account.setFullName(accountRequest.getFullName());
        account.setEmail(accountRequest.getEmail());
        account.setPhone(accountRequest.getPhone());
        account.setQualification(accountRequest.getQualification());
        account.setExperience(accountRequest.getExperience());
        account.setRoleEnum(RoleEnum.THERAPIST);
        Account newAccount = authenticationRepository.save(account);
        return newAccount;
    }

    public Account registerStaff(StaffAccountRequest accountRequest) {

        Account account = new Account();
        account.setUsername(accountRequest.getUsername());
        account.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
        account.setFullName(accountRequest.getFullName());
        account.setEmail(accountRequest.getEmail());
        account.setPhone(accountRequest.getPhone());
        account.setRoleEnum(RoleEnum.STAFF);
        Account newAccount = authenticationRepository.save(account);
        return newAccount;
    }
}
