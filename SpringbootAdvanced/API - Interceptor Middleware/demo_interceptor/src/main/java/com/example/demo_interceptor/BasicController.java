package com.example.demo_interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class BasicController {

    @GetMapping("/time")
    public LocalDateTime getTime() {
        return LocalDateTime.now();
    }
}