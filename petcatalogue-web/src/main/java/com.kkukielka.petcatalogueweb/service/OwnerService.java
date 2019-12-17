package com.kkukielka.petcatalogueweb.service;

import com.kkukielka.petcataloguemodel.model.Owner;

import java.util.List;

public interface OwnerService {
    List<Owner> getOwners();
    Owner saveOwner(Owner owner);
}
