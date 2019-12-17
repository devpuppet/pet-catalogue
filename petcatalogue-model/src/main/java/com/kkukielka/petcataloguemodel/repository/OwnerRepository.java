package com.kkukielka.petcataloguemodel.repository;

import com.kkukielka.petcataloguemodel.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    List<Owner> findAll();
}
