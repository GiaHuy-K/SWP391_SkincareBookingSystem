package com.seroter.skincare_booking.repository;

import com.seroter.skincare_booking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthenticationRepository extends JpaRepository<Account, Long> {
    Account findById(long id);

    Optional<Account> findByUsername(String username);
}
