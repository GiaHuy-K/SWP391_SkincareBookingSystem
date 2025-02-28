package com.seroter.skincare_booking.repository;


import com.seroter.skincare_booking.entity.Account;
import com.seroter.skincare_booking.entity.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedBack, Long> {

}