package com.seroter.skincare_booking.api;

import com.seroter.skincare_booking.model.response.SkincareServiceResponse;
import com.seroter.skincare_booking.service.SpaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SecurityRequirement(name = "api")
@RequestMapping("api/service")
public class SpaServiceAPI {

    @Autowired
    private SpaService spaService;

    // Lấy tất cả các dịch vụ chưa bị xóa
    @GetMapping("/all-active")
    public ResponseEntity<List<SkincareServiceResponse>> getAllServiceActive() {
        List<SkincareServiceResponse> activeServices = spaService.getAllServiceActive();
        return ResponseEntity.ok(activeServices);
    }
}