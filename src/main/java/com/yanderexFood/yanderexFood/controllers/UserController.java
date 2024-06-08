package com.yanderexFood.yanderexFood.controllers;

import com.yanderexFood.yanderexFood.YanderexFoodApplication;
import com.yanderexFood.yanderexFood.configs.JwtCore;
import com.yanderexFood.yanderexFood.dto.SigninRequest;
import com.yanderexFood.yanderexFood.models.AppUser;
import com.yanderexFood.yanderexFood.models.UserDetailsImpl;
import com.yanderexFood.yanderexFood.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtCore jwtCore;

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<?> register(@RequestBody AppUser user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Optional<AppUser> userExists = userRepository.findByUsername(user.getUsername());

        if (userExists.isEmpty()) return ResponseEntity.ok(userRepository.save(user));

        return ResponseEntity.ok("Такой пользователь уже существует");
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<?> login(@RequestBody SigninRequest signinRequest) {

        if (userRepository.findByUsername(signinRequest.getUserName()).isPresent()) {

            UserDetailsImpl builtUser = UserDetailsImpl.build(userRepository.findByUsername(signinRequest.getUserName()).get());
            builtUser.setPassword(passwordEncoder.encode(builtUser.getPassword()));

            String jwt = jwtCore.generateToken(builtUser);
            YanderexFoodApplication.currentUser = builtUser;

            return ResponseEntity.ok(jwt);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
