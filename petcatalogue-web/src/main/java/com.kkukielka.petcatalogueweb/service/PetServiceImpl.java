package com.kkukielka.petcatalogueweb.service;

import com.kkukielka.petcataloguemodel.model.Pet;
import com.kkukielka.petcataloguemodel.repository.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    @Transactional
    public List<Pet> getPets() {
        return petRepository.findAll();
    }

    @Override
    @Transactional
    public Pet savePet(Pet pet) {

        if (pet == null) {
            throw new RuntimeException("Pet is null");
        }

        Pet savedPet = petRepository.save(pet);
        return savedPet;
    }
}
