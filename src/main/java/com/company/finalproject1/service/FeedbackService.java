package com.company.finalproject1.service;

import com.company.finalproject1.configuration.ApiConnect;
import com.company.finalproject1.dto.FeedbackResponseDto;
import com.company.finalproject1.entity.FeedbackEntity;
import com.company.finalproject1.repository.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final CarRepo carRepo;
    private final ModelMapper mapper;
    private final DriverRepo driverRepo;
    private final TaxiResponseRepo taxiResponseRepo;

    private final OrderRepo orderRepo;
    private final ApiConnect apiConnect;
    private final FeedbackRepo feedbackRepo;

    public List<FeedbackResponseDto> acceptFeedback(long orderId){
        List<FeedbackResponseDto> feedbackResponseDto = apiConnect.acceptFeedback(orderId);
        FeedbackEntity feedback = mapper.map(feedbackResponseDto, FeedbackEntity.class);
        feedbackRepo.save(feedback);
        return feedbackResponseDto;
    }


















}
