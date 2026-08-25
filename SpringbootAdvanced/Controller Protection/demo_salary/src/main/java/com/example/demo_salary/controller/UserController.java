package com.example.demo_salary.controller;

import com.example.demo_salary.entity.User;
import com.example.demo_salary.entity.Role;
import com.example.demo_salary.repository.RoleRepository;
import com.example.demo_salary.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        if (user.getUsername() == null || user.getUsername().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username is required");
        }
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password is required");
        }

        String username = user.getUsername().trim();
        if (userRepository.existsByUsername(username)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }

        user.setId(null);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(resolveRoles(user.getRoles()));

        return userRepository.save(user);
    }

    // GET ALL
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody User user) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        if (user.getUsername() == null || user.getUsername().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username is required");
        }

        String username = user.getUsername().trim();
        userRepository.findByUsername(username)
                .filter(found -> !found.getId().equals(id))
                .ifPresent(found -> {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
                });

        existingUser.setUsername(username);
        if (user.getPassword() != null && !user.getPassword().isBlank()) {
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        existingUser.setRoles(resolveRoles(user.getRoles()));

        return userRepository.save(existingUser);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        userRepository.delete(user);
    }

    private Set<Role> resolveRoles(Set<Role> requestedRoles) {
        if (requestedRoles == null || requestedRoles.isEmpty()) {
            return new HashSet<>();
        }

        Set<Role> roles = new HashSet<>();
        for (Role requestedRole : requestedRoles) {
            Role role;
            if (requestedRole.getId() != null) {
                role = roleRepository.findById(requestedRole.getId())
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "Role not found: " + requestedRole.getId()));
            } else if (requestedRole.getName() != null && !requestedRole.getName().isBlank()) {
                role = roleRepository.findByNameIgnoreCase(requestedRole.getName().trim())
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "Role not found: " + requestedRole.getName()));
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Each role needs an id or name");
            }
            roles.add(role);
        }
        return roles;
    }
}
