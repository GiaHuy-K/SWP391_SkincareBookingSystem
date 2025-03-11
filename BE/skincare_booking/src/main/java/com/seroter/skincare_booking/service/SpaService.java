package com.seroter.skincare_booking.service;

import com.seroter.skincare_booking.entity.SkincareService;
import com.seroter.skincare_booking.model.response.SkincareServiceResponse;
import com.seroter.skincare_booking.repository.SkincareServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpaService {

    @Autowired
    private SkincareServiceRepository skincareServiceRepository;

    // Lấy tất cả các dịch vụ chưa bị xóa (isDeleted = false)
    public List<SkincareServiceResponse> getAllServiceActive() {
        List<SkincareService> activeServices = skincareServiceRepository.findByIsDeletedFalse();
        List<SkincareServiceResponse> responses = new ArrayList<>();

        for (SkincareService service : activeServices) {
            SkincareServiceResponse response = new SkincareServiceResponse();
            response.setId(service.getId());
            response.setName(service.getName());
            response.setDescription(service.getDescription());
            response.setPrice(service.getPrice());
            response.setDuration(service.getDuration());
            responses.add(response);
        }

        return responses;
    }
}