package com.airconsole.wm_cms.controller;

import com.airconsole.wm_cms.listener.request.auth.LoginReq;
import com.airconsole.wm_cms.listener.request.auth.SignUpReq;
import com.airconsole.wm_cms.listener.response.base.BaseResp;
import com.airconsole.wm_cms.listener.response.base.ErrorCode;
import com.airconsole.wm_cms.listener.response.base.JwtAuthenticationResp;
import com.airconsole.wm_cms.model.entities.User;
import com.airconsole.wm_cms.model.repository.UserRepository;
import com.airconsole.wm_cms.security.CurrentUser;
import com.airconsole.wm_cms.security.JwtTokenProvider;
import com.airconsole.wm_cms.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public @ResponseBody ResponseEntity<?> authenticateUser(@Valid @RequestBody final LoginReq loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResp(jwt));
    }

    @PostMapping("/signup")
    @PreAuthorize("hasRole('ADD_USER')")
    public ResponseEntity<?> registerUser(
            @CurrentUser UserPrincipal currentUser,
            @Valid @RequestBody final SignUpReq signUpRequest
    ) {

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>(new BaseResp(ErrorCode.USER_EXIST), HttpStatus.OK);
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new BaseResp(ErrorCode.EMAIL_EXIST), HttpStatus.OK);
        }

        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateBy(currentUser.getUsername());

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new BaseResp(ErrorCode.SUCCESS));
    }
}
