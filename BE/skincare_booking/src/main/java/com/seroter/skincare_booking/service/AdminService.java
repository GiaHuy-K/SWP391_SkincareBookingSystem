package com.seroter.skincare_booking.service;

import com.seroter.skincare_booking.entity.Account;
import com.seroter.skincare_booking.entity.SkincareService;
import com.seroter.skincare_booking.enums.RoleEnum;
import com.seroter.skincare_booking.exception.EntityNotFound;
import com.seroter.skincare_booking.model.request.*;
import com.seroter.skincare_booking.model.response.CustomerRegistrationResponse;
import com.seroter.skincare_booking.model.response.SkincareServiceResponse;
import com.seroter.skincare_booking.repository.AuthenticationRepository;
import com.seroter.skincare_booking.repository.SkincareServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminService {

    @Autowired
    AuthenticationRepository authenticationRepository;
    @Autowired
    SkincareServiceRepository skincareServiceRepository;



    public SkincareServiceResponse createSkincareService(SkincareRequest skincareServiceRequest) {

        SkincareService newSkincareService = new SkincareService();
        newSkincareService.setName(skincareServiceRequest.getName());
        newSkincareService.setDescription(skincareServiceRequest.getDescription());
        newSkincareService.setPrice(skincareServiceRequest.getPrice());
        newSkincareService.setDuration(skincareServiceRequest.getDuration());

        newSkincareService = skincareServiceRepository.save(newSkincareService);
        SkincareServiceResponse skincareServiceResponse = new SkincareServiceResponse();
        skincareServiceResponse.setName(newSkincareService.getName());
        skincareServiceResponse.setDescription(newSkincareService.getDescription());
        skincareServiceResponse.setPrice(newSkincareService.getPrice());
        skincareServiceResponse.setDuration(newSkincareService.getDuration());
        skincareServiceResponse.setId(newSkincareService.getId());

        return skincareServiceResponse;
    }

    public SkincareServiceResponse deleteSkincareService(Long id) {
        Optional<SkincareService> optionalSkincareService = skincareServiceRepository.findById(id);
        if (optionalSkincareService.isPresent()) {
            SkincareService skincareService = optionalSkincareService.get();
            skincareService.setIsDeleted(true); // Sử dụng isDeleted để đánh dấu xóa mềm
            SkincareService updatedService = skincareServiceRepository.save(skincareService); // Lưu thay đổi
            SkincareServiceResponse response = new SkincareServiceResponse();
            response.setId(updatedService.getId());
            response.setName(updatedService.getName());
            response.setDescription(updatedService.getDescription());
            response.setPrice(updatedService.getPrice());
            response.setDuration(updatedService.getDuration());
            return response;
        } else {
            throw new RuntimeException("SkincareService with ID " + id + " not found");
        }
    }

    public SkincareService updateSkincareService(Long id, SkincareService skincareServiceRequest) {
        Optional<SkincareService> existingSkincareService = skincareServiceRepository.findById(id);


        if (existingSkincareService.isPresent()) {
            SkincareService skincareServiceToUpdate = existingSkincareService.get();


            if (skincareServiceRequest.getName() != null) {
                skincareServiceToUpdate.setName(skincareServiceRequest.getName());
            }
            if (skincareServiceRequest.getDescription() != null) {
                skincareServiceToUpdate.setDescription(skincareServiceRequest.getDescription());
            }
            if (skincareServiceRequest.getPrice() != null) {
                skincareServiceToUpdate.setPrice(skincareServiceRequest.getPrice());
            }
            if (skincareServiceRequest.getDuration() != null) {
                skincareServiceToUpdate.setDuration(skincareServiceRequest.getDuration());
            }

            // Save and return the updated SkincareService
            return skincareServiceRepository.save(skincareServiceToUpdate);
        } else {
            throw new EntityNotFound("SkincareService with ID " + id + " not found");
        }
    }

    public List<SkincareServiceResponse> getSkincareServiceById(Long id) {
        Optional<SkincareService> skincareServices = skincareServiceRepository.findById(id);
        List<SkincareServiceResponse> responses = new ArrayList<>();
        SkincareService skincareService = skincareServices.get();
            SkincareServiceResponse skincareServiceResponse = new SkincareServiceResponse();
            skincareServiceResponse.setId(skincareService.getId());
            skincareServiceResponse.setName(skincareService.getName());
            skincareServiceResponse.setDescription(skincareService.getDescription());
            skincareServiceResponse.setPrice(skincareService.getPrice());
            skincareServiceResponse.setDuration(skincareService.getDuration());
            responses.add(skincareServiceResponse);

            return responses;
    }

    public List<SkincareServiceResponse> getSkincareService() {
        List<SkincareService> skincareServices = skincareServiceRepository.findAll();
        List<SkincareServiceResponse> responses = new ArrayList<>();
        for (SkincareService skincareService : skincareServices) {
            SkincareServiceResponse skincareServiceResponse = new SkincareServiceResponse();
            skincareServiceResponse.setId(skincareService.getId());
            skincareServiceResponse.setName(skincareService.getName());
            skincareServiceResponse.setDescription(skincareService.getDescription());
            skincareServiceResponse.setPrice(skincareService.getPrice());
            skincareServiceResponse.setDuration(skincareService.getDuration());
            responses.add(skincareServiceResponse);
        }

        return responses;
    }

    public List<CustomerRegistrationResponse> getAccountByRole(RoleEnum role) {
//        RoleEnum roleEnum = getRoleEnum(role);
        List<Account> accounts = authenticationRepository.findAllByRoleEnum(role);
        List<CustomerRegistrationResponse> responses = new ArrayList<>();
        for (Account account : accounts) {
            CustomerRegistrationResponse customerRegistrationResponse = new CustomerRegistrationResponse();
            customerRegistrationResponse.setUsername(account.getUsername());
            customerRegistrationResponse.setId(account.getId());
            customerRegistrationResponse.setFullName(account.getFullName());
            customerRegistrationResponse.setEmail(account.getEmail());
            customerRegistrationResponse.setRoleEnum(account.getRoleEnum());
            responses.add(customerRegistrationResponse);
        }
        return responses;
    }

//    public RoleEnum getRoleEnum(String role) {
//        return switch (role) {
//            case "STAFF" -> RoleEnum.STAFF;
//            case "THERAPIST" -> RoleEnum.THERAPIST;
//            case "ADMIN" -> RoleEnum.ADMIN;
//            case "CUSTOMER" -> RoleEnum.CUSTOMER;
//            default -> null;
//        };
//    }

}
