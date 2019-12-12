package com.kkukielka.petcatalogueweb.mapper;

import org.modelmapper.ModelMapper;

public abstract class AbstractMapper {

    protected ModelMapper modelMapper;

    public AbstractMapper() {
        this.modelMapper = new ModelMapper();
    }

}
