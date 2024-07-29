package com.company.finalproject1.security.model;

import com.company.finalproject1.entity.DriverEntity;
import com.company.finalproject1.repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private DriverRepo repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<DriverEntity> driver = Optional.ofNullable(repository.findByUsername(username));
        if (driver.isPresent()) {
            var driverObj = driver.get();
            return User.builder()
                    .username(driverObj.getUsername())
                    .password(driverObj.getPassword())
                    .roles(getRoles(driverObj))
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    private String[] getRoles(DriverEntity user) {
        if (user.getRole() == null) {
            return new String[]{"USER"};
        }
        return user.getRole().split(",");
    }
}
