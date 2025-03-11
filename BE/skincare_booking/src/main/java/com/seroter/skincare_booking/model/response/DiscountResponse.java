package com.seroter.skincare_booking.model.response;

import com.seroter.skincare_booking.entity.Discount;
import com.seroter.skincare_booking.enums.DiscountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountResponse {

        private String code;
        private String description;
        private BigDecimal discountValue;
        private DiscountTypeEnum discountTypeEnum;
        private LocalDateTime validFrom;
        private LocalDateTime validUntil;

    }



