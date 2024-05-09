package com.company.finalproject1.repository;

import com.company.finalproject1.entity.TaxiResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiResponseRepo extends JpaRepository <TaxiResponseEntity, Long> {
}
