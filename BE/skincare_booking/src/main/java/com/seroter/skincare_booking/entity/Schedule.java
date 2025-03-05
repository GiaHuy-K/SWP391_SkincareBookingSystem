package com.seroter.skincare_booking.entity;


import com.seroter.skincare_booking.enums.EmployeeTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "schedules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleID;

    @Column(nullable = false)
    private Long therapistID;

    @Column(nullable = false)
    private Long staffID;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EmployeeTypeEnum employeeType;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false, length = 50)
    private String status;
}
