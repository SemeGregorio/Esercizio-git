package com.example.demo_salary.controller;

import com.example.demo_salary.entity.Role;
import com.example.demo_salary.repository.RoleRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Role createRole(@RequestBody Role role) {
        if (role.getName() == null || role.getName().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Role name is required");
        }

        String normalizedName = role.getName().trim().toUpperCase(Locale.ROOT);
        if (normalizedName.startsWith("ROLE_")) {
            normalizedName = normalizedName.substring("ROLE_".length());
        }
        if (roleRepository.existsByNameIgnoreCase(normalizedName)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Role already exists");
        }

        role.setId(null);
        role.setName(normalizedName);
        return roleRepository.save(role);
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
