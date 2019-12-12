package com.kkukielka.petcataloguemodel.repository;

import com.kkukielka.petcataloguemodel.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
