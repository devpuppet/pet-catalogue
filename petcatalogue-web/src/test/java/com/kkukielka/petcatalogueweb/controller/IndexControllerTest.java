package com.kkukielka.petcatalogueweb.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class IndexControllerTest {

    private IndexController indexController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        indexController = new IndexController();
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    void getIndex() throws Exception {

        mockMvc.perform(get("/index"))
                .andExpect(status().isOk());

    }
}