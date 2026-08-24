package com.example.demo_student.controller;

import com.example.demo_student.entity.Student;
import com.example.demo_student.repository.StudentRepository;
import com.example.demo_student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    public StudentController(
            StudentRepository studentRepository,
            StudentService studentService) {

        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    // (1) CREATE
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // (2) GET ALL
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // (3) GET BY ID
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // (4) UPDATE PRIMARY KEY
    @PutMapping("/{id}")
    public Student updatePrimaryKey(
            @PathVariable Long id,
            @RequestBody Student student) {

        Long newId = student.getId();

        if (studentRepository.existsById(newId)) {
            throw new RuntimeException("Student with this ID already exists");
        }

        int updated = studentRepository.updatePrimaryKey(id, newId);

        if (updated == 0) {
            throw new RuntimeException("Student not found");
        }

        return studentRepository.findById(newId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // (5) UPDATE isWorking
    @PatchMapping("/{id}/working")
    public Student updateWorking(
            @PathVariable Long id,
            @RequestParam boolean working) {

        return studentService.changeWorking(id, working);
    }

    // (6) DELETE
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}