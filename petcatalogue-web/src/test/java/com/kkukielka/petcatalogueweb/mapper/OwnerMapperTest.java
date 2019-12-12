package com.kkukielka.petcatalogueweb.mapper;

import com.kkukielka.petcataloguemodel.model.Owner;
import com.kkukielka.petcataloguemodel.model.Pet;
import com.kkukielka.petcatalogueweb.dto.OwnerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OwnerMapperTest {

    private OwnerMapper ownerMapper = new OwnerMapper();

    @Test
    void convertToDto() {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setName("Mike");
        owner.addPet(new Pet());

        OwnerDto ownerDto = ownerMapper.convertToDto(owner);
        Assertions.assertEquals(owner.getId(), ownerDto.getId());
        Assertions.assertEquals(owner.getName(), ownerDto.getName());
    }

    @Test
    void convertToEntity() {
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setId(1L);
        ownerDto.setName("Mike");

        Owner owner = ownerMapper.convertToEntity(ownerDto);
        Assertions.assertEquals(ownerDto.getId(), owner.getId());
        Assertions.assertEquals(ownerDto.getName(), owner.getName());
    }
}