package com.seroter.skincare_booking.api;

import com.seroter.skincare_booking.model.Customer;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerAPI {

    List<Customer> customers = new ArrayList<>();

    @PostMapping
    public ResponseEntity createNewCustomer(@Valid @RequestBody Customer customer) {
        customers.add(customer);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        return ResponseEntity.ok(customers);
    }
}
