package com.seroter.skincare_booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


    @Entity
    @Getter
    @Setter
    @Table(name = "Therapist")
    public class Therapist {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long therapistID;

        @Column(nullable = false, length = 100)
        private String name;

        @Column(nullable = false, length = 255)
        private String qualification;

        @Column(nullable = false, length = 50)
        private String experience;
    }
