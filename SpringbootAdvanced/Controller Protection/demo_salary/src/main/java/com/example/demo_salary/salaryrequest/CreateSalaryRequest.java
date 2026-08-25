package com.example.demo_salary.salaryrequest;

import java.math.BigDecimal;

public record CreateSalaryRequest(BigDecimal amount, Long userId) {
}
