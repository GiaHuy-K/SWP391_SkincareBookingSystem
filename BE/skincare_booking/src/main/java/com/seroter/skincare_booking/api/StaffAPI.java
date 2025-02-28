package com.seroter.skincare_booking.api;

import com.seroter.skincare_booking.model.Staff;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffAPI {

    List<Staff> staffs = new ArrayList<>();

    @PostMapping("staff")
    public ResponseEntity createNewStaff(@Valid @RequestBody Staff staff) {
        staffs.add(staff);
        return ResponseEntity.ok(staff);
    }

    @GetMapping("staff")
    public ResponseEntity getAllStaffs() {
        return ResponseEntity.ok(staffs);
    }
}
