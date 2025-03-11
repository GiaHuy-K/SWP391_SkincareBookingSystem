package com.seroter.skincare_booking.entity;

import com.seroter.skincare_booking.enums.BookingEnum;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Booking")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime bookAt;
    private LocalDateTime checkInAt;
    private LocalDateTime checkOutAt;

    @Enumerated(EnumType.STRING)
    private BookingEnum status;

    // Mối quan hệ với Customer (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Account customer;

    // Mối quan hệ với Therapist (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "therapist_id")
    private Account therapist;

    // Mối quan hệ với SkincareService (Many-to-One)
    @ManyToMany
    @JoinTable(name = "booking_services",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "skincare_service_id"))
    private Set<SkincareService> skincareServices;

    // **Many-to-One với Staff**
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Account staff;
}
