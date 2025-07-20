package com.shuaib.hscodes.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shuaib.hscodes.security.dto.UserLoginDTO;
import com.shuaib.hscodes.security.dto.UserRegisterDTO;
import com.shuaib.hscodes.security.dto.UserVerifyDTO;
import com.shuaib.hscodes.security.entity.User;
import com.shuaib.hscodes.security.response.LoginResponse;
import com.shuaib.hscodes.security.service.AuthenticationService;
import com.shuaib.hscodes.security.service.JwtService;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        User registerUser = authenticationService.signup(userRegisterDTO);
        return ResponseEntity.ok(registerUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody UserLoginDTO userLoginDTO) {
        User authenticateUser = authenticationService.authenticate(userLoginDTO);
        String jwtToken = jwtService.generateToken(authenticateUser);
        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyUser(@RequestBody UserVerifyDTO userVerifyDTO) {
        try {
            authenticationService.verifyUser(userVerifyDTO);
            return ResponseEntity.ok("Account verified successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/resend")
    public ResponseEntity<?> resendVerificationCode(@RequestParam String email) {
        try {
            authenticationService.resendVerificationCode(email);
            return ResponseEntity.ok("Verfication code sent");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
