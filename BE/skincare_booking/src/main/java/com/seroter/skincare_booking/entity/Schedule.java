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
    @Column(name = "id")
    private Long scheduleID;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EmployeeTypeEnum employeeType;

    @Column(nullable = false)
    private LocalDate date;


    @Column(nullable = false, length = 50)
    private String status;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Account staff;

    @ManyToOne
    @JoinColumn(name = "therapist_id")
    private Account therapist;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;

    @OneToOne(mappedBy = "schedule")
    private Booking booking;
}






