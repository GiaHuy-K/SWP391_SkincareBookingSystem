package com.seroter.skincare_booking.repository;

import com.seroter.skincare_booking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository extends JpaRepository<Account, Long> {
}
