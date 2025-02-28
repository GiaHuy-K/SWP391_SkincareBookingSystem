package com.seroter.skincare_booking.api;

import com.seroter.skincare_booking.entity.Customer;
import com.seroter.skincare_booking.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerAPI {

    @Autowired
    CustomerService customerService;

    List<Customer> customers = new ArrayList<>();

    @PostMapping
    public ResponseEntity createNewCustomer(@Valid @RequestBody Customer customer) {
        customers.add(customer);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {

        List<Customer> customers = customerService.getAllProduct();
        return ResponseEntity.ok(customers);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete (@PathVariable long id){
        Customer customer  = customerService.delete(id);
        return  ResponseEntity.ok(customer);
    }
}
