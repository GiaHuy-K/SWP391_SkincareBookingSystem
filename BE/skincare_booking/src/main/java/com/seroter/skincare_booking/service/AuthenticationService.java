package com.seroter.skincare_booking.Service;

import com.seroter.skincare_booking.entity.Account;


import com.seroter.skincare_booking.enums.RoleEnum;
import com.seroter.skincare_booking.model.request.AccountRequest;
import com.seroter.skincare_booking.model.request.AuthenticationRequest;
import com.seroter.skincare_booking.model.response.AuthenticationResponse;
import com.seroter.skincare_booking.repository.AuthenticationRepository;
import com.seroter.skincare_booking.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public Account register(@Valid AccountRequest accountRequest) {
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


        Account newAccount = authenticationRepository.save(account);
        return newAccount;
    }

    public Account login() {


        return null;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return authenticationRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Account not found "));
    }

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        try{
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

        return authenticationResponse;
    }
}
