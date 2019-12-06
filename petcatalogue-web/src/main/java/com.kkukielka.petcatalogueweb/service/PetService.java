package com.kkukielka.petcatalogueweb.service;

import com.kkukielka.petcataloguemodel.model.Pet;

import java.util.List;

public interface PetService {
    List<Pet> getPets();
    Pet savePet(Pet pet);
}
