package com.seroter.skincare_booking.service;

import com.seroter.skincare_booking.entity.Account;


import com.seroter.skincare_booking.entity.SkincareService;
import com.seroter.skincare_booking.enums.RoleEnum;
import com.seroter.skincare_booking.exception.AuthorizeException;
import com.seroter.skincare_booking.exception.DuplicateEntity;
import com.seroter.skincare_booking.exception.EntityNotFound;
import com.seroter.skincare_booking.model.request.*;
import com.seroter.skincare_booking.model.response.AuthenticationResponse;
import com.seroter.skincare_booking.model.response.CustomerRegistrationResponse;
import com.seroter.skincare_booking.repository.AuthenticationRepository;
import com.seroter.skincare_booking.repository.SkincareServiceRepository;
import com.seroter.skincare_booking.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    AuthenticationRepository authenticationRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;
    @Autowired
    private SkincareServiceRepository skincareServiceRepository;

    public CustomerRegistrationResponse register(@Valid AccountRequest accountRequest) {
//        // => pass vòng validation
//        boolean isDuplicate = false;
//        if(isDuplicate){
//            // => báo lỗi
//            throw new DuplicateEntity("Duplicate!");
//        }else{
//            // lưu vào database
//            return account;
//        }
        Account account = new Account();
        account.setUsername(accountRequest.getUsername());
        account.setRoleEnum(RoleEnum.CUSTOMER);
        account.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
        account.setFullName(accountRequest.getFullName());
        account.setEmail(accountRequest.getEmail());
        account.setPhone(accountRequest.getPhone());

//        try {
            account = authenticationRepository.save(account);
            CustomerRegistrationResponse response = new CustomerRegistrationResponse();
            response.setId(account.getId());
            response.setUsername(account.getUsername());
            response.setFullName(account.getFullName());
            response.setEmail(account.getEmail());
            response.setRoleEnum(account.getRoleEnum());
            return response;
//        } catch (Exception e) {
//            if(e.getMessage().contains(accountRequest.getEmail())){
//                throw new DuplicateEntity("Duplicate email");
//            }
//            if(e.getMessage().contains(accountRequest.getPhone())){
//                throw new DuplicateEntity("Duplicate phone");
//            }
//            if(e.getMessage().contains(accountRequest.getUsername())){
//                throw new DuplicateEntity("Duplicate username");
//            }
//            throw e;
//        }
    }

    public Account login() {


        return null;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return authenticationRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Account not found "));
    }

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    )
            );
        } catch (Exception e) {
            throw new NullPointerException("Wrong username or password");
        }
        Account account = authenticationRepository.findByUsername(authenticationRequest.getUsername()).orElseThrow();
        String token = tokenService.generateToken(account);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setEmail(account.getEmail());
        authenticationResponse.setId(account.getId());
        authenticationResponse.setFullName(account.getFullName());
        authenticationResponse.setUsername(account.getUsername());
        authenticationResponse.setToken(token);
        authenticationResponse.setRoleEnum(account.getRoleEnum());

        return authenticationResponse;
    }

    public Account register(AdminAccountRequest accountRequest) {

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
        Set<SkincareService> skincareServices = new HashSet<>();
        Set<Long> skincareServiceIds = accountRequest.getSkinCareServiceIds();
        for (Long skincareServiceId : skincareServiceIds) {
            Optional<SkincareService> skincareService = Optional.ofNullable(skincareServiceRepository.findById(skincareServiceId).orElseThrow(() -> new EntityNotFound("ID do not exist")));
            skincareServices.add(skincareService.get());

        }
        account.setSkincareServices(skincareServices);
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
