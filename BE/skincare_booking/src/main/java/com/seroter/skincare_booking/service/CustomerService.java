package com.seroter.skincare_booking.service;

import com.seroter.skincare_booking.entity.Account;
import com.seroter.skincare_booking.entity.Customer;
import com.seroter.skincare_booking.repository.AuthenticationRepository;
import com.seroter.skincare_booking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AuthenticationRepository authenticationRepository;

    public List<Customer> getAllProduct(){
        return customerRepository.findCustomersByIsDeletedFalse();
    }

    public Account create (Account account){
        return authenticationRepository.save(account);
    }

    public Customer delete(long id){
        Customer customer = customerRepository.findCustomerById(id);
        customer.isDeleted = true;
        return customerRepository.save(customer);

    }

    private void testCommit(){

    }

    private void testCommitViet(){

    }
}
