//package com.company.finalproject1.security;
//
//import com.company.finalproject1.entity.DriverEntity;
//import com.company.finalproject1.repository.DriverRepo;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//@RequiredArgsConstructor
//public class JwtUserDetailsService implements UserDetailsService {
//    private final DriverRepo driverRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       DriverEntity user = driverRepo.findByUsername(username);
//
//        if (user != null) {
//            return new User(user.getUsername(), user.getPassword(),
//                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//    }
//
//}