package com.seroter.skincare_booking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    private boolean isDeleted = false;

    @ManyToMany(mappedBy = "skincareServices")
    private Set<Booking> bookings;

    public void setIsDeleted(boolean b) {
        this.isDeleted = b; // Cập nhật giá trị isDeleted
    }
}