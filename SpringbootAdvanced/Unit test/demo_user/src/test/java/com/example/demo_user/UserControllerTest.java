package com.example.demo_user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createUserTest() throws Exception {

        String userJson = """
                {
                    "name": "Mario",
                    "surname": "Rossi",
                    "email": "mario@test.com"
                }
                """;

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk());
    }

    @Test
    void getAllUsersTest() throws Exception {

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());
    }

    @Test
    void getUserTest() throws Exception {

        User user = new User();
        user.setName("Luca");
        user.setSurname("Bianchi");
        user.setEmail("luca@test.com");

        // Prima creiamo l'utente
        String userJson = """
                {
                    "name": "Luca",
                    "surname": "Bianchi",
                    "email": "luca@test.com"
                }
                """;

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk());

        // Poi lo recuperiamo
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk());
    }

    @Test
    void updateUserTest() throws Exception {

        String userJson = """
                {
                    "name": "Mario",
                    "surname": "Rossi",
                    "email": "mario@test.com"
                }
                """;

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk());

        String updatedUserJson = """
                {
                    "name": "Mario",
                    "surname": "Verdi",
                    "email": "mario.verdi@test.com"
                }
                """;

        mockMvc.perform(put("/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedUserJson))
                .andExpect(status().isOk());
    }

    @Test
    void deleteUserTest() throws Exception {

        String userJson = """
                {
                    "name": "Anna",
                    "surname": "Bianchi",
                    "email": "anna@test.com"
                }
                """;

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk());

        mockMvc.perform(delete("/users/1"))
                .andExpect(status().isOk());
    }
}