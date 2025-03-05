package com.seroter.skincare_booking.repository;

import com.seroter.skincare_booking.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByDate(LocalDate date);
    List<Schedule> findByTherapistID(Long therapistID);
    List<Schedule> findByStaffID(Long staffID);

}
