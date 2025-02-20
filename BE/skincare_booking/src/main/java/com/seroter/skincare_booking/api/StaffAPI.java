package com.seroter.skincare_booking.api;

import com.seroter.skincare_booking.model.Staff;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StaffAPI {

    List<Staff> staffs = new ArrayList<>();

    @PostMapping("staff")
    public ResponseEntity createNewStaff(@RequestBody Staff staff) {
        staffs.add(staff);
        return ResponseEntity.ok(staff);
    }

    @GetMapping("staff")
    public ResponseEntity getAllStaffs() {
        return ResponseEntity.ok(staffs);
    }
}
