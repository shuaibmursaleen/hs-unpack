package com.shuaib.hscodes.security.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shuaib.hscodes.security.dto.UserLoginDTO;
import com.shuaib.hscodes.security.dto.UserRegisterDTO;
import com.shuaib.hscodes.security.dto.UserVerifyDTO;
import com.shuaib.hscodes.security.entity.User;
import com.shuaib.hscodes.security.repository.UserRepository;

import jakarta.mail.MessagingException;

@Service
public class AuthenticationService {

    @Value("${security.config.auth-server}")
    private String authServer;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.emailService = emailService;
    }

    public User signup(UserRegisterDTO input) {
        Optional<User> userWithSameEmail = userRepository.findByEmail(input.getEmail());
        Optional<User> userWithSameName = userRepository.findByUsername(input.getUsername());

        if (userWithSameEmail.isPresent()) {
            if (userWithSameEmail.get().isEnabled()) {
                return null;
            } else {
                resendVerificationCode(input.getEmail());
                return userWithSameEmail.get();
            }
        }

        if (userWithSameName.isPresent()) {
            if (userWithSameName.get().getEmail().equals(input.getEmail())) {
                if (userWithSameName.get().isEnabled()) {
                    return null;
                } else {
                    resendVerificationCode(input.getEmail());
                    return userWithSameName.get();
                }
            } else return null;
        }

        User user = new User(input.getUsername(), input.getEmail(), passwordEncoder.encode(input.getPassword()));
        user.setVerificationCode(generateVerificationCode());
        user.setVerificationCodeExpireTime(LocalDateTime.now().plusMinutes(15));
        user.setEnabled(false);
        sendVerificationEmail(user);
        return userRepository.save(user);
    }

    public User authenticate(UserLoginDTO input) {
        Optional<User> optionalUser = userRepository.findByEmail(input.getEmail());
        
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (!user.isEnabled()) {
                throw new RuntimeException("Not verified");
            }
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));
            return user;
        }

        else {
            throw new RuntimeException("Not found");
        }
    }

    public void verifyUser(UserVerifyDTO input) {
        Optional<User> optionalUser = userRepository.findByVerificationCode(input.getVerificationToken());
        
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getVerificationCodeExpireTime().isBefore(LocalDateTime.now())) {
                throw new RuntimeException("Verification code expired");
            }
            if (user.getVerificationCode().equals(input.getVerificationToken())) {
                user.setEnabled(true);
                user.setVerificationCode(null);
                user.setVerificationCodeExpireTime(null);
                userRepository.save(user);
            }
            else {
                throw new RuntimeException("Invalid verification code");
            }
        } else {
            throw new RuntimeException("user not found");
        }
    }

    public void resendVerificationCode(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.isEnabled()) {
                throw new RuntimeException("Account is already verified");
            }
            user.setVerificationCode(generateVerificationCode());
            user.setVerificationCodeExpireTime(LocalDateTime.now().plusMinutes(15));
            sendVerificationEmail(user);
            userRepository.save(user);
        }
        else {
            throw new RuntimeException("User not found");
        }
    }

    private String generateVerificationCode() {
        return UUID.randomUUID().toString();
        
    }
    
    private void sendVerificationEmail(User user) {
        String subject = "Account Verification Link";
        String verificationCode = user.getVerificationCode();

        String htmlMessage = "<html>"
                + "<body style=\"font-family: Arial, sans-serif;\">"
                + "<div style=\"background-color: #f5f5f5; padding: 20px;\">"
                + "<h2 style=\"color: #333;\">Welcome to our app!</h2>"
                + "<p style=\"font-size: 16px;\">Please click the verification link below to continue:</p>"
                + "<div style=\"background-color: #fff; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1);\">"
                + "<h3 style=\"color: #333;\">Verification Link:</h3>"
                + "<a href=\"" + authServer + "/auth/verify/" + verificationCode + "\" style=\"font-size: 18px; font-weight: bold; color: #007bff;\">" + authServer + "/auth/verify/" + verificationCode + "</a>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";

        try {
            emailService.sendVerificationEmail(user.getEmail(), subject, htmlMessage);
        } catch (MessagingException e) {
            // Handle email sending exception
            e.printStackTrace();
        }
    }

}
