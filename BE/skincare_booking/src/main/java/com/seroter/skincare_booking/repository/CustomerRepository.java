package com.seroter.skincare_booking.repository;

import com.seroter.skincare_booking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerById (long id);

    List<Customer> findCustomersByIsDeletedFalse();

}
