package com.seroter.skincare_booking.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlotResponse {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String nameString;
}