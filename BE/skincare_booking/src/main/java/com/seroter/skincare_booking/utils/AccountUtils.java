package com.seroter.skincare_booking.utils;

import com.seroter.skincare_booking.entity.Account;
import com.seroter.skincare_booking.repository.AuthenticationRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AccountUtils implements ApplicationContextAware {
    private static AuthenticationRepository userRepo;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        userRepo = applicationContext.getBean(AuthenticationRepository.class);
    }
    public Account getCurrentAccount(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepo.findByUsername(username).orElseThrow();
    }


}
