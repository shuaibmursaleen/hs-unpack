package com.shuaib.hscodes.security.jwt;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shuaib.hscodes.security.user.CustomUser;

@RestController
public class LoginController {
    
    private final AuthenticationManager manager;

    public LoginController(AuthenticationManager manager) {
        this.manager = manager;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody CustomUser user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        Authentication authentication = manager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwtToken = JwtUtil.generateToken((User) authentication.getPrincipal());

        Map<String, String> response = new HashMap<>();
        response.put("token", jwtToken);
        
        return ResponseEntity.ok(response);
    }

    @GetMapping("/me")
    public ResponseEntity<String> getCurrentUser(@AuthenticationPrincipal String username) {
        if (username == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("not authenticated");
        }
        
        return ResponseEntity.ok(username);
    }
}
