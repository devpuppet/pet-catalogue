package com.kkukielka.petcatalogueweb.bootstrap;

import com.kkukielka.petcataloguemodel.model.Pet;
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

    public Bootstrap(PetService petService) {
        this.petService = petService;
    }

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Pet pet1 = Pet.builder().name("Doggo").build();
        Pet pet2 = Pet.builder().name("Catto").build();

        petService.savePet(pet1);
        petService.savePet(pet2);

        log.debug("Following pets have been saved into db:\n");
        petService.getPets().forEach(System.out::println);

    }

}
