package com.shuaib.hscodes.security.user;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomUserController {
    private final PasswordEncoder encoder;
    private final CustomUserRepository userRepository;

    public CustomUserController(PasswordEncoder encoder, CustomUserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @PostMapping("/createuser")
    public ResponseEntity<String> createUser(@RequestBody CustomUser user) {
        Optional<CustomUser> optionalUser = userRepository.findByUsername(user.getUsername());
        if(!optionalUser.isPresent()) {
            userRepository.save(new CustomUser(new ObjectId(), user.getUsername(), encoder.encode(user.getPassword())));
            return ResponseEntity.ok("Success");
        }
        return ResponseEntity.badRequest().body("Failure");
    }
}
