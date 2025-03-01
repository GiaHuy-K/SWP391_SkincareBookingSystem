package com.seroter.skincare_booking.repository;

import com.seroter.skincare_booking.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    Optional<Discount> findByCode(String code);
    List<Discount> findByValidUntilAfter(LocalDate date);
}
