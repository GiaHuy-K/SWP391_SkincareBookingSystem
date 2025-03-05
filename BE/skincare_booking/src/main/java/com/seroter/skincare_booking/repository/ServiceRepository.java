package com.seroter.skincare_booking.repository;

import com.seroter.skincare_booking.entity.SpaService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<SpaService, Long> {
}
