package com.seroter.skincare_booking.api;

import com.seroter.skincare_booking.entity.Account;
import com.seroter.skincare_booking.model.request.AccountRequest;
import com.seroter.skincare_booking.model.request.AuthenticationRequest;
import com.seroter.skincare_booking.model.response.AuthenticationResponse;
import com.seroter.skincare_booking.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RestControllerAdvice
@RequestMapping("/api")

public class AuthenticationAPI {
    @Autowired
    AuthenticationService authenticationService;

    public AuthenticationAPI() {
    }

    @PostMapping({"register"})
    public ResponseEntity register(@RequestBody @Valid AccountRequest account) {
        Account newAccount = this.authenticationService.register(account);
        return ResponseEntity.ok(newAccount);
    }

    @PostMapping({"login"})
    public ResponseEntity login(@RequestBody AuthenticationRequest authenticationRequest) {
        AuthenticationResponse authenticationResponse = authenticationService.login(authenticationRequest);
        return ResponseEntity.ok(authenticationResponse);
    }
}
