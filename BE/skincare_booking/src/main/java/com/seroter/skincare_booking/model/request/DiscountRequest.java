package com.seroter.skincare_booking.model.request;

import com.seroter.skincare_booking.enums.DiscountTypeEnum;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountRequest {
    private String code;
    private String description;
    private BigDecimal discountValue;
    private DiscountTypeEnum discountType;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
}

