package com.example.demo_salary.repository;

import com.example.demo_salary.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
    Optional<Salary> findByUserId(Long userId);
}
