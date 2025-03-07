package com.seroter.skincare_booking.model.response;

import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkincareServiceResponse {
    private Long id;
    private String name;

    private String description;

    private BigDecimal price;

    private Integer duration;
}
