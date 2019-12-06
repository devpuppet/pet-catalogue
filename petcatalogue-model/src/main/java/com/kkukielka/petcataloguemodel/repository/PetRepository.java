package com.kkukielka.petcataloguemodel.repository;

import com.kkukielka.petcataloguemodel.model.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Long> {

    List<Pet> findAll();
}
