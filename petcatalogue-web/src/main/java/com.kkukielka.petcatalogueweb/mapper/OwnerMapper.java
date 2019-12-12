package com.kkukielka.petcatalogueweb.mapper;

import com.kkukielka.petcataloguemodel.model.Owner;
import com.kkukielka.petcatalogueweb.dto.OwnerDto;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper extends AbstractMapper implements Mapper<OwnerDto, Owner> {
    @Override
    public OwnerDto convertToDto(Owner entity) {
        OwnerDto ownerDto = modelMapper.map(entity, OwnerDto.class);
        return ownerDto;
    }

    @Override
    public Owner convertToEntity(OwnerDto dto) {
        Owner owner = modelMapper.map(dto, Owner.class);
        return owner;
    }
}
