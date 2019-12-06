package com.kkukielka.petcatalogueweb.controller;

import com.kkukielka.petcataloguemodel.model.Pet;
import com.kkukielka.petcatalogueweb.service.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets")
    public List<Pet> getPets() {
        return petService.getPets();
    }

}
