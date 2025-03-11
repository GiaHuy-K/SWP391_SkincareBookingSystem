package com.seroter.skincare_booking.repository;

import com.seroter.skincare_booking.entity.SkincareService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkincareServiceRepository extends JpaRepository<SkincareService, Long> {
    SkincareService findById(long id);
}
