package com.example.demo_components;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private MyService myService;

    public MyController(MyService myService) {
        System.out.println("MyController constructor");
        this.myService = myService;
    }

    @GetMapping("/getName")
    public String getName() {
        return myService.getName();
    }

    @GetMapping("/")
    public String welcome() {
        return "Benvenuto nella mia applicazione Spring Boot!";
    }
}