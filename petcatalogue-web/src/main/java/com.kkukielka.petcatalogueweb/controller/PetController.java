package com.kkukielka.petcatalogueweb.controller;

import com.kkukielka.petcataloguemodel.model.Pet;
import com.kkukielka.petcatalogueweb.dto.PetDto;
import com.kkukielka.petcatalogueweb.mapper.PetMapper;
import com.kkukielka.petcatalogueweb.service.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PetController {

    private PetService petService;
    private PetMapper petMapper;

    public PetController(PetService petService, PetMapper petMapper) {
        this.petService = petService;
        this.petMapper = petMapper;
    }

    @GetMapping("/pets")
    public List<PetDto> getPets() {
        List<Pet> pets = petService.getPets();

        List<PetDto> petsDto = pets
                .stream()
                .map(pet -> petMapper.convertToDto(pet))
                .collect(Collectors.toList());

        return petsDto;
    }

    @PostMapping("/pet/new")
    public PetDto savePet(@RequestBody PetDto petDto) {
        Pet pet = petMapper.convertToEntity(petDto);

        Pet savedPet = petService.savePet(pet);

        PetDto savedPetDto = petMapper.convertToDto(savedPet);

        return savedPetDto;
    }

}
