package com.seroter.skincare_booking.repository;

import com.seroter.skincare_booking.entity.Account;
import com.seroter.skincare_booking.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthenticationRepository extends JpaRepository<Account, Long> {
    Account findById(long id);

    Optional<Account> findByUsername(String username);

    List<Account> findAllByRoleEnum(RoleEnum roleEnum);
}
