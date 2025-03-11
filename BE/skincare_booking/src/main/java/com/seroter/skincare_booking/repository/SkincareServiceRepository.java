package com.seroter.skincare_booking.repository;

import com.seroter.skincare_booking.entity.SkincareService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkincareServiceRepository extends JpaRepository<SkincareService, Long> {
    Optional<SkincareService> findById(Long id);

    List<SkincareService> findByIsDeletedFalse();
}