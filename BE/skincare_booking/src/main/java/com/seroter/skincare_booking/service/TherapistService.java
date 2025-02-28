package com.seroter.skincare_booking.service;

import com.seroter.skincare_booking.entity.Service;
import com.seroter.skincare_booking.entity.Therapist;
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

    @ManyToOne
    @JoinColumn(name = "therapistID", referencedColumnName = "therapistID", nullable = false)
    private Therapist therapist;

    @ManyToOne
    @JoinColumn(name = "serviceID", referencedColumnName = "serviceID", nullable = false)
    private Service service;
}


