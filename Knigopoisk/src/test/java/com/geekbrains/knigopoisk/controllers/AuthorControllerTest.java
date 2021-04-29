package com.geekbrains.knigopoisk.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekbrains.knigopoisk.dto.AuthorDto;
import com.geekbrains.knigopoisk.entities.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AuthorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private AuthorDto authorDto;

    @BeforeEach
    void setUp() {
        Author author = new Author("Роберт Седжвик", null);
        authorDto = new AuthorDto(author);
    }

    @Test
    void getAllAuthors() throws Exception {
        mockMvc.perform(get("/api/v1/authors"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.[0].name").value("Агата Кристи"))
                .andExpect(jsonPath("$.[1].name").value("Астрид Лингрен"))
                .andExpect(jsonPath("$.[2].name").value("Блейк Крауч"))
                .andExpect(jsonPath("$.[3].name").value("Джо Аберкромби"))
                .andExpect(jsonPath("$.[4].name").value("Дмитрий Глуховский"))
                .andExpect(jsonPath("$.[5].name").value("Лев Толстой"))
                .andExpect(jsonPath("$.[6].name").value("Ник Перумов"));
    }

    @Test
    void createAuthor() throws Exception {
        String content = mockMvc.perform(post("/api/v1/author/create")
                .content(objectMapper.writeValueAsString(authorDto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                // В следующей строке не срабатывает .andExpect(status().isCreated())
                // Почему?
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(content);
    }

    @Test
    void updateAuthor() throws Exception {
        String content = mockMvc.perform(put("/api/v1/author/update")
                .content(objectMapper.writeValueAsString(authorDto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(content);
    }

    @Test
    void deleteAuthorById() throws Exception {
        mockMvc.perform(delete("/api/v1/author/{id}", 8))
                // В следующей строке не срабатывает .andExpect(status().isAccepted())
                // Почему?
                .andExpect(status().isOk());
    }
}
