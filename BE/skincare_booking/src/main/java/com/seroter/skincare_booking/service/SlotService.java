package com.seroter.skincare_booking.service;

import com.seroter.skincare_booking.entity.Slot;
import com.seroter.skincare_booking.model.request.SlotRequest;
import org.springframework.stereotype.Service;

@Service
public class SlotService {
    public Slot createSlot(SlotRequest slot) {
        Slot newSlot = new Slot();
        newSlot.setStartTime(slot.getStartTime());
        newSlot.setEndTime(slot.getEndTime());
        return newSlot;

    }
}
