package com.kkukielka.petcatalogueweb.mapper;

import com.kkukielka.petcataloguemodel.model.Owner;
import com.kkukielka.petcataloguemodel.model.Pet;
import com.kkukielka.petcatalogueweb.dto.OwnerDto;
import com.kkukielka.petcatalogueweb.dto.PetDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PetMapperTest {

    private PetMapper petMapper = new PetMapper();
    private OwnerMapper ownerMapper = new OwnerMapper(petMapper);

    @Test
    void convertToDto() {
        // given
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("Doggo");
        Owner owner = new Owner();
        owner.setName("Mike");
        pet.setOwner(owner);

        // when
        PetDto petDto = petMapper.convertToDto(pet);

        // then
        Assertions.assertEquals(pet.getId(), petDto.getId());
        Assertions.assertEquals(pet.getName(), petDto.getName());
        Assertions.assertEquals(pet.getOwner(), ownerMapper.convertToEntity(petDto.getOwner()));
    }

    @Test
    void convertToEntity() {
        // given
        PetDto petDto = new PetDto();
        petDto.setId(1L);
        petDto.setName("Doggo");
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setName("Mike");
        petDto.setOwner(ownerDto);

        // when
        Pet pet = petMapper.convertToEntity(petDto);

        // then
        Assertions.assertEquals(petDto.getId(), pet.getId());
        Assertions.assertEquals(petDto.getName(), pet.getName());
        Assertions.assertEquals(petDto.getOwner(), ownerMapper.convertToDto(pet.getOwner()));
    }
}