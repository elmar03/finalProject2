package com.company.finalproject1.controller;

import com.company.finalproject1.dto.FeedbackRequestDto;
import com.company.finalproject1.dto.FeedbackResponseDto;
import com.company.finalproject1.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
@RequiredArgsConstructor

public class FeedbackController {

  private final FeedbackService feedbackService;
  @GetMapping("/feedbackByOrderId")
  public List<FeedbackResponseDto> acceptFeedback(@RequestParam Long orderId){
    return feedbackService.acceptFeedback(orderId);
  }



}
