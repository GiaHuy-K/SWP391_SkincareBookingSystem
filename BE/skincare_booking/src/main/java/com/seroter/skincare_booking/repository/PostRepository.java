package com.seroter.skincare_booking.repository;


import com.seroter.skincare_booking.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

}

