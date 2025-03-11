package com.seroter.skincare_booking.api;

import com.seroter.skincare_booking.entity.Discount;
import com.seroter.skincare_booking.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/discounts")
public class DiscountAPI {

    @Autowired
    private DiscountService discountService;

    @GetMapping
    public List<Discount> getAllDiscounts() {
        return discountService.getAllDiscounts();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Discount> getDiscountByCode(@PathVariable String code) {
        Optional<Discount> discount = discountService.getDiscountByCode(code);
        return discount.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Discount createDiscount(@RequestBody Discount discount) {
        return discountService.createDiscount(discount);
    }

    @GetMapping("/validate/{code}")
    public ResponseEntity<Boolean> isDiscountValid(@PathVariable String code) {
        return ResponseEntity.ok(discountService.isDiscountValid(code));
    }
}

