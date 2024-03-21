package com.company.finalproject1.repository;

import com.company.finalproject1.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository <CarEntity, Long> {
}
