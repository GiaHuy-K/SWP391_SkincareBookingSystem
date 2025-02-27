package com.seroter.skincare_booking.api;

import com.seroter.skincare_booking.model.Therapist;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/therapist")
public class TherapistAPI {

    List<Therapist> therapists = new ArrayList<>();

    @PostMapping("therapist")
    public ResponseEntity createNewTherapist(@RequestBody Therapist therapist) {
        therapists.add(therapist);
        return ResponseEntity.ok(therapist);
    }

    @GetMapping("therapist")
    public ResponseEntity getAllTherapists() {
        return ResponseEntity.ok(therapists);
    }
}
