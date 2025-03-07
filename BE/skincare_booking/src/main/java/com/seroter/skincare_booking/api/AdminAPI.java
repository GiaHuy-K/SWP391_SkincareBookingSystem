package com.seroter.skincare_booking.api;
import com.seroter.skincare_booking.entity.Account;
import com.seroter.skincare_booking.entity.SkincareService;
import com.seroter.skincare_booking.model.request.*;
import com.seroter.skincare_booking.model.response.AuthenticationResponse;
import com.seroter.skincare_booking.service.AdminService;
import com.seroter.skincare_booking.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/admin")
public class AdminAPI {

    @Autowired
    AdminService adminService;

    @PostMapping({"register"})
    public ResponseEntity register(@RequestBody @Valid AdminAccountRequest account) {
        Account newAccount = this.adminService.register(account);
        return ResponseEntity.ok(newAccount);
    }


    @PostMapping({"registertherapist"})
    public ResponseEntity register(@RequestBody @Valid TherapistAccountRequest account) {
        Account newAccount = this.adminService.registerTherapist(account);
        return ResponseEntity.ok(newAccount);
    }

    @PostMapping({"registerstaff"})
    public ResponseEntity register(@RequestBody @Valid StaffAccountRequest account) {
        Account newAccount = this.adminService.registerStaff(account);
        return ResponseEntity.ok(newAccount);
    }

    @PostMapping({"skinCareService"})
    public ResponseEntity addSkinCareService(@RequestBody @Valid SkincareService skincareService) {
        SkincareService newSkincareService = this.adminService.createSkincareService(skincareService);
        return ResponseEntity.ok(newSkincareService);
    }
}
