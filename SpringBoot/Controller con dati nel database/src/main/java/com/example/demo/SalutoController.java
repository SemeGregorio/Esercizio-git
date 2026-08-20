package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalutoController {

    private final SalutoRepository repository;

    public SalutoController(SalutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/v3/ciao")
    public String ciao() {
        return repository.findById(1)
                .map(Saluto::getTesto)
                .orElse("Saluto non trovato");
    }
}