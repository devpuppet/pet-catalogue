package com.kkukielka.petcatalogueweb.bootstrap;

import com.kkukielka.petcataloguemodel.model.Owner;
import com.kkukielka.petcataloguemodel.model.Pet;
import com.kkukielka.petcatalogueweb.service.OwnerService;
import com.kkukielka.petcatalogueweb.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private PetService petService;
    private OwnerService ownerService;

    public Bootstrap(PetService petService, OwnerService ownerService) {
        this.petService = petService;
        this.ownerService = ownerService;
    }

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Pet pet1 = Pet.builder().name("Doggo").build();
        Pet pet2 = Pet.builder().name("Catto").build();

        Owner owner1 = new Owner();
        owner1.setName("Kamil");
        owner1.getPets().add(pet1);

        Owner owner2 = new Owner();
        owner2.setName("Sara");
        owner2.getPets().add(pet2);

        pet1.setOwner(owner1);
        pet2.setOwner(owner2);

        petService.savePet(pet1);
        petService.savePet(pet2);

        log.debug("Following pets have been saved into db:\n");
        petService.getPets().forEach(System.out::println);

    }

}
