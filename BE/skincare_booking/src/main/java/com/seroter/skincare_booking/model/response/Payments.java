package com.seroter.skincare_booking.model.response;


import com.seroter.skincare_booking.entity.Account;
import com.seroter.skincare_booking.enums.PaymentStatusEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Payments")
@Data
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public long id = 0;
    public Date createAt;
    public float total;
    public PaymentStatusEnum status = PaymentStatusEnum.PENDING;
    @ManyToOne
    @JoinColumn(name = "account_id")
    public Account account;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    List<PaymentDetail> paymentDetails = new ArrayList<>();
}
