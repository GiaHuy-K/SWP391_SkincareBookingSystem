package com.seroter.skincare_booking.repository;

import com.seroter.skincare_booking.entity.Payment;
import com.seroter.skincare_booking.enums.PaymentStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStatus(PaymentStatusEnum status);
}
