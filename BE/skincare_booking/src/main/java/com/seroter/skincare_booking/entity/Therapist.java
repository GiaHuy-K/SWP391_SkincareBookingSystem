package com.seroter.skincare_booking.entity;

import com.seroter.skincare_booking.service.TherapistService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "Therapist")
public class Therapist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long therapistID;

    private String name;
    private String qualification;
    private String experience;

    @OneToMany(mappedBy = "therapist", cascade = CascadeType.ALL)
    private List<TherapistService> therapistServices;
}


