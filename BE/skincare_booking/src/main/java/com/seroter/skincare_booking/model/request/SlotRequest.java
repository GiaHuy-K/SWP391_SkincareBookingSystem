package com.seroter.skincare_booking.model.request;

import com.seroter.skincare_booking.entity.Slot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SlotRequest {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
