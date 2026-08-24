package com.example.demo_student.controller;

import com.example.demo_student.entity.Student;
import com.example.demo_student.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository.deleteAll();
    }

    // (1) CREATE
    @Test
    void shouldCreateStudent() throws Exception {

        mockMvc.perform(post("/students")
                        .contentType(APPLICATION_JSON)
                        .content("""
                                {
                                    "name": "Mario",
                                    "surname": "Rossi",
                                    "working": true
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mario"))
                .andExpect(jsonPath("$.surname").value("Rossi"))
                .andExpect(jsonPath("$.working").value(true));
    }

    // (2) GET ALL
    @Test
    void shouldGetAllStudents() throws Exception {

        studentRepository.save(
                createStudent("Mario", "Rossi", true)
        );

        studentRepository.save(
                createStudent("Luca", "Bianchi", false)
        );

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    // (3) GET BY ID
    @Test
    void shouldGetStudentById() throws Exception {

        Student student = studentRepository.save(
                createStudent("Mario", "Rossi", true)
        );

        mockMvc.perform(get("/students/" + student.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mario"))
                .andExpect(jsonPath("$.surname").value("Rossi"));
    }

    // (4) UPDATE PRIMARY KEY
    @Test
    void shouldUpdatePrimaryKey() throws Exception {

        Student student = studentRepository.save(
                createStudent("Mario", "Rossi", true)
        );

        Long oldId = student.getId();
        Long newId = 10L;

        mockMvc.perform(put("/students/" + oldId)
                        .contentType(APPLICATION_JSON)
                        .content("""
                            {
                                "id": 10
                            }
                            """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(10));

        mockMvc.perform(get("/students/" + newId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(10));
    }

    // (5) UPDATE isWorking
    @Test
    void shouldUpdateWorking() throws Exception {

        Student student = studentRepository.save(
                createStudent("Mario", "Rossi", false)
        );

        mockMvc.perform(
                        patch("/students/" + student.getId() + "/working")
                                .param("working", "true")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.working").value(true));
    }

    // (6) DELETE
    @Test
    void shouldDeleteStudent() throws Exception {

        Student student = studentRepository.save(
                createStudent("Mario", "Rossi", true)
        );

        Long id = student.getId();

        mockMvc.perform(delete("/students/" + id))
                .andExpect(status().isOk());

        assertTrue(studentRepository.findById(id).isEmpty());
    }

    private Student createStudent(
            String name,
            String surname,
            boolean working) {

        Student student = new Student();

        student.setName(name);
        student.setSurname(surname);
        student.setWorking(working);

        return student;
    }
}