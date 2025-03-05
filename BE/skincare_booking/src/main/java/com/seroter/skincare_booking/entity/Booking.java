package com.seroter.skincare_booking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "booking")
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)



    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

    @ManyToMany(cascade = CascadeType.ALL)
            @JoinTable(name = "booking_services",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name ="service_id")
            )
    List<SpaService> services = new ArrayList<>();

    LocalDateTime startTime;
    LocalDateTime endTime;

    @Enumerated(EnumType.STRING)

    LocalDateTime createAt;


}
