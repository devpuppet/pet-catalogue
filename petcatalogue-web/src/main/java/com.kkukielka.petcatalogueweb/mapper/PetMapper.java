package com.kkukielka.petcatalogueweb.mapper;

import com.kkukielka.petcataloguemodel.model.Pet;
import com.kkukielka.petcatalogueweb.dto.PetDto;
import org.springframework.stereotype.Component;

@Component
public class PetMapper extends AbstractMapper implements Mapper<PetDto, Pet>{
    @Override
    public PetDto convertToDto(Pet entity) {
        PetDto petDto = modelMapper.map(entity, PetDto.class);
        return petDto;
    }

    @Override
    public Pet convertToEntity(PetDto dto) {
        Pet pet = modelMapper.map(dto, Pet.class);
        return pet;
    }
}
