package com.seroter.skincare_booking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "skincareservice")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkincareService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skincare_service_id")
    private int id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int duration;



}
