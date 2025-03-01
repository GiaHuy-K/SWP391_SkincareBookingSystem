package com.seroter.skincare_booking.repository;

import com.seroter.skincare_booking.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findByRole(String role);
}

