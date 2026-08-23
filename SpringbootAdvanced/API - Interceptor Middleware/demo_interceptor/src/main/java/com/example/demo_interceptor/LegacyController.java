package com.example.demo_interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LegacyController {

    @GetMapping("/legacy")
    public String legacy() {
        return "This is just old code";
    }
}