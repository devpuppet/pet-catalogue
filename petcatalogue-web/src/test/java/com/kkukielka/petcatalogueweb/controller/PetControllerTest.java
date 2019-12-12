package com.kkukielka.petcatalogueweb.controller;

import com.kkukielka.petcataloguemodel.model.Owner;
import com.kkukielka.petcataloguemodel.model.Pet;
import com.kkukielka.petcatalogueweb.dto.OwnerDto;
import com.kkukielka.petcatalogueweb.dto.PetDto;
import com.kkukielka.petcatalogueweb.mapper.OwnerMapper;
import com.kkukielka.petcatalogueweb.mapper.PetMapper;
import com.kkukielka.petcatalogueweb.service.PetService;
import com.kkukielka.petcatalogueweb.util.GsonHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PetControllerTest {

    @Mock
    private PetService petService;

    private PetMapper petMapper = new PetMapper();

    private OwnerMapper ownerMapper = new OwnerMapper();

    private PetController petController;

    private MockMvc mockMvc;

    private GsonHelper gsonHelper = new GsonHelper();

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

        String petName = "Scooby";
        PetDto petDto = new PetDto();
        petDto.setOwner(ownerDto);
        petDto.setName(petName);

        Pet returnPet = Pet.builder().id(1L).name(petName).owner(owner).build();

        when(petService.savePet(any(Pet.class))).thenReturn(returnPet);

        // when
        MockHttpServletResponse response = mockMvc
                .perform(post("/pet/new")
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("utf-8")
                    .content(gsonHelper.toJson(petDto))
                )
                .andExpect(status().isOk())
                .andReturn().getResponse();

        Pet savedPet = gsonHelper.fromJson(response.getContentAsString(), Pet.class);

        // then
        Assertions.assertEquals(returnPet, savedPet);
        verify(petService, times(1)).savePet(any(Pet.class));

    }
}