package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalutoController {

    @GetMapping("/v2/ciao/{provincia}")
    public Saluto ciao(
            @PathVariable String provincia,
            @RequestParam String nome) {

        String saluto = "Ciao " + nome + ", com'è il tempo in " + provincia + "?";

        return new Saluto(nome, provincia, saluto);
    }
}