package com.seroter.skincare_booking.repository;

import com.seroter.skincare_booking.entity.Cancellation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CancellationRepository extends JpaRepository<Cancellation, Long> {
    List<Cancellation> findByBookingID(Long bookingID);
}