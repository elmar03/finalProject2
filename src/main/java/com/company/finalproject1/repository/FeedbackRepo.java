package com.company.finalproject1.repository;

import com.company.finalproject1.entity.CarEntity;
import com.company.finalproject1.entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo extends JpaRepository<FeedbackEntity, Long> {

    FeedbackEntity findByOrderID(Long orderId);

}
