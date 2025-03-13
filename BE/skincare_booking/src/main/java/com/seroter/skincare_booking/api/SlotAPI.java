package com.seroter.skincare_booking.api;

import com.seroter.skincare_booking.entity.Slot;
import com.seroter.skincare_booking.model.request.SlotRequest;
import com.seroter.skincare_booking.model.response.SlotResponse;
import com.seroter.skincare_booking.service.SlotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/slots")
@SecurityRequirement(name = "api")
public class SlotAPI {

    private final SlotService slotService;

    @Autowired
    public SlotAPI(SlotService slotService) {
        this.slotService = slotService;
    }


    @Operation(summary = "Create a new slot", description = "Create a slot with start and end time")
    @PostMapping("/create")
    public ResponseEntity<SlotResponse> createSlot(@RequestBody SlotRequest slotRequest) {
        SlotResponse createdSlot = slotService.createSlot(slotRequest);
        return ResponseEntity.ok(createdSlot);
    }
}
