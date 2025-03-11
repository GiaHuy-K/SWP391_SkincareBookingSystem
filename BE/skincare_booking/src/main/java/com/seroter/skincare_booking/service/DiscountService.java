package com.seroter.skincare_booking.service;

import com.seroter.skincare_booking.entity.Discount;
import com.seroter.skincare_booking.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    public Optional<Discount> getDiscountByCode(String code) {
        return discountRepository.findByCode(code);
    }

    public Discount createDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    public boolean isDiscountValid(String code) {
        Optional<Discount> discount = discountRepository.findByCode(code);
        return discount.isPresent() && discount.get().getValidUntil().isAfter(LocalDate.now());
    }
}

