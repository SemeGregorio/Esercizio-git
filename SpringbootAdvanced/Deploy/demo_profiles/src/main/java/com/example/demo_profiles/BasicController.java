package com.example.demo_profiles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class BasicController {

    @GetMapping("/")
    public int getSum() {

        Random random = new Random();

        int number1 = random.nextInt(100);
        int number2 = random.nextInt(100);

        return number1 + number2;
    }
}