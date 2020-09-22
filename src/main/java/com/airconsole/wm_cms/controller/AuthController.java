package com.airconsole.wm_cms.controller;


import com.airconsole.wm_cms.model.entities.UserEntity;
import com.airconsole.wm_cms.model.repository.RoleRepo;
import com.airconsole.wm_cms.model.repository.UserRepo;
import com.airconsole.wm_cms.payload.reponse.BaseResponse;
import com.airconsole.wm_cms.payload.reponse.ErrorCode;
import com.airconsole.wm_cms.payload.reponse.JwtAuthenticationResponse;
import com.airconsole.wm_cms.payload.request.LoginRequest;
import com.airconsole.wm_cms.payload.request.SignUpRequest;
import com.airconsole.wm_cms.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUserEntity(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUserEntity(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepo.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>(new BaseResponse(ErrorCode.FAILED, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepo.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new BaseResponse(ErrorCode.FAILED, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        UserEntity userEntity = new UserEntity(signUpRequest.getFullName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword());

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

        UserEntity result = userRepo.save(userEntity);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/user/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new BaseResponse(ErrorCode.SUCCESS, "User registered successfully"));
    }
}