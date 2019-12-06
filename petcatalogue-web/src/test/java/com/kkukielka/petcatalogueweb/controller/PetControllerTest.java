package com.kkukielka.petcatalogueweb.controller;

import com.kkukielka.petcatalogueweb.service.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PetControllerTest {

    @Mock
    private PetService petService;

    private PetController petController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        petController = new PetController(petService);

        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
    }

    @Test
    void getPets() throws Exception {

        mockMvc.perform(get("/pets"))
                .andExpect(status().isOk());

        verify(petService, times(1)).getPets();

    }

}