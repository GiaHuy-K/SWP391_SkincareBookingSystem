package com.seroter.skincare_booking.entity;

import com.seroter.skincare_booking.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffID;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String contactInfor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private RoleEnum role;
}

