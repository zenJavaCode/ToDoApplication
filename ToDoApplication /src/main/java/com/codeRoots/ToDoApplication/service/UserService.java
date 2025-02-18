package com.codeRoots.ToDoApplication.service;

import com.codeRoots.ToDoApplication.exception.ResourceNotFoundException;
import com.codeRoots.ToDoApplication.model.User;
import com.codeRoots.ToDoApplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.security.SecureRandom;

@Service

public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        UserDetails customUserDetails = new CustomUserDetails(user);

        return customUserDetails;

    }
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final JavaMailSender mailSender;
//
//    public User registerUser(String email, String password, String role) {
//        User user = new User();
//        user.setEmail(email);
//        user.setPassword(passwordEncoder.encode(password));
//        user.setRole(role);
//        user.setProvider("LOCAL");
//        user.setVerificationToken(generateVerificationToken());
//
//        User savedUser = userRepository.save(user);
//        sendVerificationEmail(savedUser);
//        return savedUser;
//    }
//
//    private void sendVerificationEmail(User user) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(user.getEmail());
//        message.setSubject("Email Verification");
//        message.setText("Please verify your email by clicking the link: "
//                + "http://localhost:8080/verify?token=" + user.getVerificationToken());
//        mailSender.send(message);
//    }
//
//    public String generateVerificationToken() {
//        SecureRandom random = new SecureRandom();
//        int code = 100000 + random.nextInt(900000); // Generates a number from 100000 to 999999
//        return String.valueOf(code);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // Fetch the user from the database
//        return (UserDetails) userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//    }
}
