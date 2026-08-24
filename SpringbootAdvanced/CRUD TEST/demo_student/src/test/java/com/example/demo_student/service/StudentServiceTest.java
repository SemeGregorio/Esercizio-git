package com.example.demo_student.service;

import com.example.demo_student.entity.Student;
import com.example.demo_student.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void shouldChangeWorkingValue() {

        Student student = new Student();

        student.setId(1L);
        student.setName("Mario");
        student.setSurname("Rossi");
        student.setWorking(false);

        when(studentRepository.findById(1L))
                .thenReturn(Optional.of(student));

        when(studentRepository.save(student))
                .thenReturn(student);

        Student result =
                studentService.changeWorking(1L, true);

        assertTrue(result.isWorking());

        verify(studentRepository).findById(1L);
        verify(studentRepository).save(student);
    }
}