package com.seroter.skincare_booking.repository;


import com.seroter.skincare_booking.entity.Therapist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TherapistRepository extends JpaRepository<Therapist, Long> {
    Optional<Therapist> findByName(String name);
}

