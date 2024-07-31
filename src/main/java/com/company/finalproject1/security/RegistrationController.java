package com.company.finalproject1.security;


import com.company.finalproject1.dto.DriverRequestDto;
import com.company.finalproject1.entity.DriverEntity;
import com.company.finalproject1.repository.DriverRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.border.Border;

@RestController
public class RegistrationController {

    @Autowired
    private DriverRepo myUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register/user")
    public ResponseEntity<String> createUser(@RequestBody DriverRequestDto driverRequestDto) {
        driverRequestDto.setPassword(passwordEncoder.encode(driverRequestDto.getPassword()));
        DriverEntity driver = modelMapper.map(driverRequestDto, DriverEntity.class);
        myUserRepository.save(driver);
        return new ResponseEntity<>("Signed up successfully", HttpStatus.CREATED);
    }
}
