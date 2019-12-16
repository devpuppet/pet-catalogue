package com.kkukielka.petcatalogueweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kkukielka.petcataloguemodel.model.Owner;
import com.kkukielka.petcatalogueweb.dto.OwnerDto;
import com.kkukielka.petcatalogueweb.dto.PetDto;
import com.kkukielka.petcatalogueweb.mapper.OwnerMapper;
import com.kkukielka.petcatalogueweb.mapper.PetMapper;
import com.kkukielka.petcatalogueweb.service.OwnerService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class OwnerControllerTest {

    private MockMvc mockMvc;

    private OwnerController ownerController;

    private PetMapper petMapper = new PetMapper();

    private OwnerMapper ownerMapper = new OwnerMapper(petMapper);

    private ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private OwnerService ownerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController(ownerService, ownerMapper);
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void saveOwner() throws Exception {
        // given
        String ownerName = "Mike";
        String petName = "Scooby";
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setName(ownerName);

        PetDto petDto = new PetDto();
        petDto.setName(petName);
        petDto.setOwner(ownerDto);
        ownerDto.setPets(Stream.of(petDto).collect(Collectors.toSet()));

        Owner expectedOwner = ownerMapper.convertToEntity(ownerDto);
        expectedOwner.setId(1L);

        when(ownerService.saveOwner(any(Owner.class))).thenReturn(expectedOwner);

        String requestString = objectMapper.writerWithView(Views.Owner.class).writeValueAsString(ownerDto);

        // when
        MockHttpServletResponse response = mockMvc.perform(
                post("/owner/new")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestString)
                    .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        String responseString = response.getContentAsString();

        OwnerDto savedOwnerDto = objectMapper.readValue(responseString, OwnerDto.class);
        Owner savedOwner = ownerMapper.convertToEntity(savedOwnerDto);

        // then
        Assertions.assertEquals(expectedOwner, savedOwner);
        verify(ownerService, times(1)).saveOwner(any(Owner.class));
    }
}