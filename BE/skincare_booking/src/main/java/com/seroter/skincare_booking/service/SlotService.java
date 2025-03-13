package com.seroter.skincare_booking.service;

import com.seroter.skincare_booking.entity.Slot;
import com.seroter.skincare_booking.model.request.SlotRequest;
import com.seroter.skincare_booking.model.response.SlotResponse;
import com.seroter.skincare_booking.repository.SlotRepository;
import com.seroter.skincare_booking.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SlotService {

    @Autowired
    SlotRepository slotRepository;

    @Autowired
    AccountUtils accountUtils;

    @Transactional
    public SlotResponse createSlot(SlotRequest slotRequest) {
        Slot slot = new Slot();
        slot.setStartTime(slotRequest.getStartTime());
        slot.setEndTime(slotRequest.getEndTime());
        slot.setDeleted(false); // Default to false
        slot.setAdmin(accountUtils.getCurrentAccount());

        Slot newSlot =  slotRepository.save(slot);
        SlotResponse slotResponse = new SlotResponse();
        slotResponse.setId(newSlot.getId());
        slotResponse.setStartTime(newSlot.getStartTime());
        slotResponse.setEndTime(newSlot.getEndTime());
        slotResponse.setNameString(newSlot.getAdmin().getFullName());
        return slotResponse;

    }
}
