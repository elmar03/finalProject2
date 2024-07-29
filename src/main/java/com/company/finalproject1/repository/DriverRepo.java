package com.company.finalproject1.repository;

import com.company.finalproject1.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepo extends JpaRepository<DriverEntity, Long> {

    DriverEntity findByUsername(String username);
}
