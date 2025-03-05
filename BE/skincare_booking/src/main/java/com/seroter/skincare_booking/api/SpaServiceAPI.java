package com.seroter.skincare_booking.api;


import com.seroter.skincare_booking.entity.SpaService;
import com.seroter.skincare_booking.model.request.SpaServiceRequest;
import com.seroter.skincare_booking.service.BeautyCareService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name = "api")
@RequestMapping("api/service")
public class SpaServiceAPI {

    @Autowired
    BeautyCareService beautyCareService;

//    @PostMapping
//    public ResponseEntity creResponseEntity (@RequestBody SpaServiceRequest spaServiceRequest){
//       SpaService spaService=  beautyCareService.createSpaService(spaServiceRequest);
//       return  ResponseEntity.ok(spaService);
//    }
}
