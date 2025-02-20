package com.seroter.skincare_booking.api;

import com.seroter.skincare_booking.model.Customer;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerAPI {

    List<Customer> customers = new ArrayList<>();

    @PostMapping("customer")
    public ResponseEntity createNewCustomer(@Valid @RequestBody Customer customer) {
        customers.add(customer);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("customer")
    public ResponseEntity getAllCustomers() {
        return ResponseEntity.ok(customers);
    }
}
