package com.example.demo.controller;

import com.example.demo.models.WebsiteUser;
import com.example.demo.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllWebSiteUser() {
        logger.info("{}", userRepository.findAll());
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> insertUser(@RequestBody WebsiteUser user) {
        Object object = userRepository.save(user);
        logger.info("{}", object);
        return new ResponseEntity<>(object, HttpStatus.ACCEPTED);
    }

}
