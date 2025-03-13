package com.seroter.skincare_booking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Slot {
    public String getName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Account admin;

    @OneToMany(mappedBy = "slot")
    private Set<Schedule> schedules;
}
