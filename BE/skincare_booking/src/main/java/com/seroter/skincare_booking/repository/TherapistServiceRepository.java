package com.seroter.skincare_booking.repository;


import com.seroter.skincare_booking.entity.TherapistService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TherapistServiceRepository extends JpaRepository<TherapistService, Long> {
    List<TherapistService> findByTherapist_TherapistID(Long therapistID);
    List<TherapistService> findByService_ServiceID(Long serviceID);
}