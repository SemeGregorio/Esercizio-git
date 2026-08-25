package com.example.cors_server.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/custom")
    public String custom() {
        return "Welcome from Spring Boot!";
    }
}