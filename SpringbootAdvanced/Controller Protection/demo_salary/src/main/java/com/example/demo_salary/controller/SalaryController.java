package com.example.demo_salary.controller;

import com.example.demo_salary.salaryrequest.CreateSalaryRequest;
import com.example.demo_salary.entity.Salary;
import com.example.demo_salary.entity.User;
import com.example.demo_salary.repository.SalaryRepository;
import com.example.demo_salary.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/salaries")
@PreAuthorize("hasRole('ADMIN')")
public class SalaryController {

    private final SalaryRepository salaryRepository;
    private final UserRepository userRepository;

    public SalaryController(SalaryRepository salaryRepository, UserRepository userRepository) {
        this.salaryRepository = salaryRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public Salary getUserSalary(@PathVariable Long userId) {
        return salaryRepository.findByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Salary not found for user: " + userId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Salary createSalary(@RequestBody CreateSalaryRequest request) {
        if (request.amount() == null || request.amount().signum() < 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Amount is required and cannot be negative");
        }
        if (request.userId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User id is required");
        }

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User not found: " + request.userId()));

        if (salaryRepository.findByUserId(request.userId()).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "This user already has a salary");
        }

        Salary salary = new Salary();
        salary.setAmount(request.amount());
        salary.setUser(user);
        return salaryRepository.save(salary);
    }
}
