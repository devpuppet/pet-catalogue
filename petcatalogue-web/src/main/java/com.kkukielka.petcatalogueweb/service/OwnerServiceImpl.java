package com.kkukielka.petcatalogueweb.service;

import com.kkukielka.petcataloguemodel.model.Owner;
import com.kkukielka.petcataloguemodel.repository.OwnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    @Transactional
    public Owner saveOwner(Owner owner) {

        if (owner == null) {
            throw new RuntimeException("Owner is null");
        }

        return ownerRepository.save(owner);
    }
}
