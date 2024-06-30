package com.company.finalproject1.service;

import com.company.finalproject1.configuration.ApiConnect;
import com.company.finalproject1.dto.FeedbackResponseDto;
import com.company.finalproject1.entity.FeedbackEntity;
import com.company.finalproject1.repository.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final ModelMapper mapper;
    private final ApiConnect apiConnect;
    private final FeedbackRepo feedbackRepo;

    public List<FeedbackResponseDto> acceptFeedback(long orderId){
        List<FeedbackResponseDto> feedbackResponseDtoList = apiConnect.acceptFeedback(orderId);
        List<FeedbackEntity> feedbackEntities = feedbackResponseDtoList.stream()
                .map(dto -> {
                    FeedbackEntity feedbackEntity = mapper.map(dto, FeedbackEntity.class);
                    feedbackEntity.setOrderID(orderId);
                    return feedbackEntity;
                })
                .collect(Collectors.toList());
        feedbackRepo.saveAll(feedbackEntities);
        FeedbackEntity byOrderID = feedbackRepo.findByOrderID(orderId);
        return Collections.singletonList(mapper.map(byOrderID, FeedbackResponseDto.class));

    }
}
