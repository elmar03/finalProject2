package com.company.finalproject1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class FeedbackRequestDto {
    private String feedback;
    private Date submissionDate;
    private Integer starNumber;
}
