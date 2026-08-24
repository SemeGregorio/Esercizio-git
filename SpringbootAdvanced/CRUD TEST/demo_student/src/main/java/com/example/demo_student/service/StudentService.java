package com.example.demo_student.service;

import com.example.demo_student.entity.Student;
import com.example.demo_student.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student changeWorking(Long id, boolean working) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setWorking(working);

        return studentRepository.save(student);
    }
}