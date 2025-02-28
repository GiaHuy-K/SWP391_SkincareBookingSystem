package com.seroter.skincare_booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TherapistService")
public class TherapistService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "therapistID", nullable = false)
    private Therapist therapist;

    @ManyToOne
    @JoinColumn(name = "serviceID", nullable = false)
    private Service service;
}

