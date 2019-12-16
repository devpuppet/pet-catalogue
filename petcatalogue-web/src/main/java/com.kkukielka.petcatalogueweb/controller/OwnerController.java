package com.kkukielka.petcatalogueweb.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kkukielka.petcataloguemodel.model.Owner;
import com.kkukielka.petcatalogueweb.dto.OwnerDto;
import com.kkukielka.petcatalogueweb.mapper.OwnerMapper;
import com.kkukielka.petcatalogueweb.service.OwnerService;
import com.kkukielka.petcatalogueweb.view.Views;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {

    private OwnerService ownerService;
    private OwnerMapper ownerMapper;

    public OwnerController(OwnerService ownerService, OwnerMapper ownerMapper) {
        this.ownerService = ownerService;
        this.ownerMapper = ownerMapper;
    }

    @JsonView(Views.Owner.class)
    @PostMapping("/owner/new")
    public OwnerDto saveOwner(@RequestBody OwnerDto ownerDto) {
        Owner owner = ownerMapper.convertToEntity(ownerDto);

        Owner savedOwner = ownerService.saveOwner(owner);

        OwnerDto savedOwnerDto = ownerMapper.convertToDto(savedOwner);

        return savedOwnerDto;
    }

}
