package com.seroter.skincare_booking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "cancellation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cancellation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cancellationID;

    @Column(nullable = false)
    private Long bookingID;

    @Column(nullable = false)
    private LocalDate cancellationDate;

    @Column(nullable = false, length = 255)
    private String reason;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal refundAmount;
}
