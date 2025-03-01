package com.seroter.skincare_booking.service;

import com.seroter.skincare_booking.entity.Account;
import com.seroter.skincare_booking.repository.AuthenticationRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class TokenService {
    @Autowired
    AuthenticationRepository authenticationRepository;

    private final String SECRET_KEY = "HT4bb6d1dfbafb64a681139d1586b6f1160d18159afd57c8c79136d7490630407c";

    private SecretKey getSigninKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Tạo token
    public String generateToken(Account account) {
        String token = Jwts.builder()
                .subject(account.getId()+"")  //Thông tin lưu trong token
                .issuedAt(new Date(System.currentTimeMillis())) //Thời gian tạo token
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) //Thời gian token đc duy trì
                .signWith(getSigninKey())
                .compact();
        return token;
    }

    // Verify token
    public Account getCustomerByToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSigninKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        String idString = claims.getSubject();
        long id = Long.parseLong(idString);

        Account account = authenticationRepository.findById(id);

        return account;
    }
}
