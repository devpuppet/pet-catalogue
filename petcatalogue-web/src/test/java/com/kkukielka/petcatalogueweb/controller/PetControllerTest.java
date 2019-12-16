package com.kkukielka.petcatalogueweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kkukielka.petcataloguemodel.model.Owner;
import com.kkukielka.petcataloguemodel.model.Pet;
import com.kkukielka.petcatalogueweb.dto.OwnerDto;
import com.kkukielka.petcatalogueweb.dto.PetDto;
import com.kkukielka.petcatalogueweb.mapper.OwnerMapper;
import com.kkukielka.petcatalogueweb.mapper.PetMapper;
import com.kkukielka.petcatalogueweb.service.PetService;
import com.kkukielka.petcatalogueweb.view.Views;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PetControllerTest {

    @Mock
    private PetService petService;

    private PetMapper petMapper = new PetMapper();

    private OwnerMapper ownerMapper = new OwnerMapper(petMapper);

    private PetController petController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        petController = new PetController(petService, petMapper);

        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
    }

    @Test
    void getPets() throws Exception {

        mockMvc.perform(get("/pets"))
                .andExpect(status().isOk());

        verify(petService, times(1)).getPets();

    }

    @Test
    void savePet() throws Exception {
        // given
        String ownerName = "Mike";
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setName(ownerName);
        Owner owner = ownerMapper.convertToEntity(ownerDto);
        owner.setId(1L);

        String petName = "Scooby";
        PetDto petDto = new PetDto();
        petDto.setOwner(ownerDto);
        petDto.setName(petName);
        ownerDto.setPets(Stream.of(petDto).collect(Collectors.toSet()));

        Pet expectedPet = Pet.builder().id(1L).name(petName).owner(owner).build();
        owner.addPet(expectedPet);

        when(petService.savePet(any(Pet.class))).thenReturn(expectedPet);
        String requestString = objectMapper.writerWithView(Views.Pet.class).writeValueAsString(petDto);

        // when
        MockHttpServletResponse response = mockMvc
                .perform(post("/pet/new")
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("utf-8")
                    .content(requestString)
                )
                .andExpect(status().isOk())
                .andReturn().getResponse();

        String responseString = response.getContentAsString();

        PetDto savedPetDto = objectMapper.readValue(responseString, PetDto.class);
        Pet savedPet = petMapper.convertToEntity(savedPetDto);

        // then
        Assertions.assertEquals(expectedPet, savedPet);
        verify(petService, times(1)).savePet(any(Pet.class));

    }
}