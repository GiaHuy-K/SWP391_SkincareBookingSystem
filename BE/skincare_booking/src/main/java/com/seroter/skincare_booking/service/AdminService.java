package com.seroter.skincare_booking.service;

import com.seroter.skincare_booking.entity.Account;
import com.seroter.skincare_booking.entity.SkincareService;
import com.seroter.skincare_booking.enums.RoleEnum;
import com.seroter.skincare_booking.exception.EntityNotFound;
import com.seroter.skincare_booking.model.request.AccountRequest;
import com.seroter.skincare_booking.model.request.AdminAccountRequest;
import com.seroter.skincare_booking.model.request.StaffAccountRequest;
import com.seroter.skincare_booking.model.request.TherapistAccountRequest;
import com.seroter.skincare_booking.repository.AuthenticationRepository;
import com.seroter.skincare_booking.repository.SkincareServiceRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AdminService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationRepository authenticationRepository;
    @Autowired
    SkincareServiceRepository skincareServiceRepository;


    public Account register( AdminAccountRequest accountRequest) {

        Account account = new Account();
        account.setUsername(accountRequest.getUsername());
        account.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
        account.setFullName(accountRequest.getFullName());
        account.setEmail(accountRequest.getEmail());
        account.setPhone(accountRequest.getPhone());
        account.setRoleEnum(RoleEnum.ADMIN);
        Account newAccount = authenticationRepository.save(account);
        return newAccount;
    }

    public Account registerTherapist(TherapistAccountRequest accountRequest) {

        Account account = new Account();
        account.setUsername(accountRequest.getUsername());
        account.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
        account.setFullName(accountRequest.getFullName());
        account.setEmail(accountRequest.getEmail());
        account.setPhone(accountRequest.getPhone());
        account.setQualification(accountRequest.getQualification());
        account.setExperience(accountRequest.getExperience());
        account.setRoleEnum(RoleEnum.THERAPIST);
        Set<SkincareService> skincareServices = new HashSet<>();
        Set<Long> skincareServiceIds = accountRequest.getSkinCareServiceIds();
        for (Long skincareServiceId : skincareServiceIds) {
            Optional<SkincareService> skincareService = Optional.ofNullable(skincareServiceRepository.findById(skincareServiceId).orElseThrow(() -> new EntityNotFound("ID do not exist")));
            skincareServices.add(skincareService.get());

        }
        account.setSkincareServices(skincareServices);
        Account newAccount = authenticationRepository.save(account);


        return newAccount;
    }

    public Account registerStaff(StaffAccountRequest accountRequest) {

        Account account = new Account();
        account.setUsername(accountRequest.getUsername());
        account.setPassword(passwordEncoder.encode(accountRequest.getPassword()));
        account.setFullName(accountRequest.getFullName());
        account.setEmail(accountRequest.getEmail());
        account.setPhone(accountRequest.getPhone());
        account.setRoleEnum(RoleEnum.STAFF);
        Account newAccount = authenticationRepository.save(account);
        return newAccount;
    }

    public SkincareService createSkincareService( SkincareService skincareService) {

        SkincareService newSkincareService = new SkincareService();
        newSkincareService.setId(skincareService.getId());
        newSkincareService.setName(skincareService.getName());
        newSkincareService.setDescription(skincareService.getDescription());
        newSkincareService.setPrice(skincareService.getPrice());
        newSkincareService.setDuration(skincareService.getDuration());

        newSkincareService = skincareServiceRepository.save(newSkincareService);
        return newSkincareService;
    }

}
