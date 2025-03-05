package com.seroter.skincare_booking.api;
import com.seroter.skincare_booking.entity.Account;
import com.seroter.skincare_booking.entity.SkincareService;
import com.seroter.skincare_booking.model.request.AccountRequest;
import com.seroter.skincare_booking.model.request.AdminAccountRequest;
import com.seroter.skincare_booking.model.request.StaffAccountRequest;
import com.seroter.skincare_booking.model.request.TherapistAccountRequest;
import com.seroter.skincare_booking.service.AdminService;
import com.seroter.skincare_booking.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("skinCareService/{id}")
    public ResponseEntity deleteResponseEntity(@PathVariable Long  id) {
        SkincareService skincareService1 = this.adminService.deleteSkincareService(id);
        return  ResponseEntity.ok(skincareService1);
    }

    @PutMapping("skinCareService/{id}")
    public ResponseEntity updateSkinCareService(@PathVariable Long id, @RequestBody @Valid SkincareService skincareServiceRequest) {
        SkincareService updatedSkincareService = this.adminService.updateSkincareService(id, skincareServiceRequest);
        return ResponseEntity.ok(updatedSkincareService);
    }

}
