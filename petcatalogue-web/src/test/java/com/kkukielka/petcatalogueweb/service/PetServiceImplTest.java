package com.kkukielka.petcatalogueweb.service;

import com.kkukielka.petcataloguemodel.model.Pet;
import com.kkukielka.petcataloguemodel.repository.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class PetServiceImplTest {

    private PetService petService;

    @Mock
    private PetRepository petRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        petService = new PetServiceImpl(petRepository);
    }

    @Test
    public void getPets() {

        // given
        Pet pet1 = Pet.builder().name("Test1").build();
        Pet pet2 = Pet.builder().name("Test2").build();

        List<Pet> pets = new ArrayList<>();
        pets.add(pet1);
        pets.add(pet2);

        when(petRepository.findAll()).thenReturn(pets);

        // when
        List<Pet> savedPets = petService.getPets();

        // then
        Assertions.assertEquals(pets.size(), savedPets.size());

        verify(petRepository, times(1)).findAll();

    }

    @Test
    public void saveValidPet() {

        // given
        String petName = "Test";
        Pet pet1 = Pet.builder().id(1L).name(petName).build();

        when(petRepository.save(any(Pet.class))).thenReturn(pet1);

        // when
        Pet savedPet = petService.savePet(pet1);

        // then
        Assertions.assertEquals(1L, savedPet.getId());
        Assertions.assertEquals(petName, savedPet.getName());

        verify(petRepository, times(1)).save(any(Pet.class));

    }

    @Test
    public void saveNullPet() {
        Pet pet = null;

        Assertions.assertThrows(RuntimeException.class, () -> petService.savePet(pet));
        verify(petRepository, times(0)).save(any(Pet.class));
    }

}