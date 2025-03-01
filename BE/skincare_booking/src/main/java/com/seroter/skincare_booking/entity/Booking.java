package com.seroter.skincare_booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int bookingID;

    public int customerID;
    public int serviceID;
    public int comboID;
    public int therapistID;
    public int discountID;


    public Date bookingDate;

    public Date scheduledDateTime;


    public Date checkInDate;

    public int staffCheckin;
    public int staffCheckout;
    public int staffAssign;

    @Temporal(TemporalType.DATE)

    public Date serviceStart;

    @Temporal(TemporalType.DATE)

    public Date serviceEnd;
    @Temporal(TemporalType.DATE)

    public Date checkOutDate;

    public String status;

    public Booking() {

    }


}
