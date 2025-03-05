package com.seroter.skincare_booking.api;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityRequirement(name = "api")
@RequestMapping("api/service")
public class SpaServiceAPI {



//    @PostMapping
//    public ResponseEntity creResponseEntity (@RequestBody SpaServiceRequest spaServiceRequest){
//       SpaService spaService=  beautyCareService.createSpaService(spaServiceRequest);
//       return  ResponseEntity.ok(spaService);
//    }
}
