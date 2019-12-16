package com.kkukielka.petcatalogueweb.mapper;

import com.kkukielka.petcataloguemodel.model.Owner;
import com.kkukielka.petcatalogueweb.dto.OwnerDto;
import com.kkukielka.petcatalogueweb.dto.PetDto;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OwnerMapper extends AbstractMapper implements Mapper<OwnerDto, Owner> {

    private PetMapper petMapper;

    public OwnerMapper(PetMapper petMapper) {
        this.petMapper = petMapper;
    }

    @Override
    public OwnerDto convertToDto(Owner entity) {
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setId(entity.getId());
        ownerDto.setName(entity.getName());
        Set<PetDto> petsDto = entity.getPets()
                .stream()
                .map(petMapper::convertToDto)
                .collect(Collectors.toSet());
        ownerDto.setPets(petsDto);
        return ownerDto;
    }

    @Override
    public Owner convertToEntity(OwnerDto dto) {
        Owner owner = modelMapper.map(dto, Owner.class);
        return owner;
    }
}
