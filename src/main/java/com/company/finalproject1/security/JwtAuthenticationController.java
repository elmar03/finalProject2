//package com.company.finalproject1.security;
//
//import com.company.finalproject1.entity.DriverEntity;
//import com.company.finalproject1.repository.DriverRepo;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Objects;
//
//@RestController
//@CrossOrigin
//public class JwtAuthenticationController {
//
//	private final AuthenticationManager authenticationManager;
//
//	private final JwtTokenUtil jwtTokenUtil;
//
//	private final UserDetailsService jwtInMemoryUserDetailsService;
//
//	private final PasswordEncoder passwordEncoder;
//
//	private final DriverRepo driverRepo;
//
//
//	public JwtAuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserDetailsService jwtInMemoryUserDetailsService, PasswordEncoder passwordEncoder, DriverRepo driverRepo) {
//		this.authenticationManager = authenticationManager;
//		this.jwtTokenUtil = jwtTokenUtil;
//		this.jwtInMemoryUserDetailsService = jwtInMemoryUserDetailsService;
//		this.passwordEncoder = passwordEncoder;
//		this.driverRepo = driverRepo;
//	}
//
//	@PostMapping("/signing")
//	public String  signIn(@RequestBody JwtRequest request)
//			throws Exception {
//
//		authenticate(request.getEmail(), request.getPassword());
//		final UserDetails userDetails = jwtInMemoryUserDetailsService
//				.loadUserByUsername(request.getEmail());
//
//		final String token = jwtTokenUtil.generateToken(userDetails);
//		AfterSignInResponseDto signInResponseDto = AfterSignInResponseDto.builder()
//				.token(token)
//				.email(request.getEmail())
//				.password(request.getPassword())
//				.role(request.getRole())
//				.build();
//
//		return  signInResponseDto.toString();
//	}
//
////	@PostMapping("/signup")
////	public ResponseEntity<?> signUp (@RequestBody SignUpDto dto){
////
////		DriverEntity driverEntity = driverRepo.findByUsername(dto.getEmail());
////		if (driverEntity == null) {
////			DriverEntity userEntity = DriverEntity.builder()
////					.username(dto.getEmail())
////					.password(passwordEncoder.encode(dto.getPassword()))
////					.role(dto.getRole())
////					.build();
////			driverRepo.save(userEntity);
////			return ResponseEntity.ok("You signed!");
////		}else
////			return ResponseEntity.ok("This account already exist in our DB!");
////
////	}
//
//	@PostMapping("/signup")
//	public ResponseEntity<?> signUp(@RequestBody SignUpDto dto) {
//		DriverEntity driverEntity = driverRepo.findByUsername(dto.getEmail());
//		if (driverEntity == null) {
//			DriverEntity userEntity = new DriverEntity();
//			userEntity.setUsername(dto.getEmail());
//			userEntity.setPassword(passwordEncoder.encode(dto.getPassword()));
//			userEntity.setRole(dto.getRole());
//
//			driverRepo.save(userEntity);
//			return ResponseEntity.ok("You signed up!");
//		} else {
//			return ResponseEntity.ok("This account already exists in our DB!");
//		}
//	}
//
//
//
//	private void authenticate(String username, String password) throws Exception {
//		Objects.requireNonNull(username);
//		Objects.requireNonNull(password);
//
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//		} catch (DisabledException e) {
//			throw new Exception("USER_DISABLED", e);
//		} catch (BadCredentialsException e) {
//			throw new Exception("INVALID_CREDENTIALS", e);
//		}
//	}
//}
