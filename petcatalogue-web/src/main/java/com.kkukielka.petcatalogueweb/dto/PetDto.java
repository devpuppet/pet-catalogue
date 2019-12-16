package com.kkukielka.petcatalogueweb.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.kkukielka.petcatalogueweb.view.Views;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PetDto {

    @JsonView(Views.Normal.class)
    private Long id;

    @JsonView(Views.Normal.class)
    private String name;

    @JsonView(Views.Pet.class)
    private OwnerDto owner;

}
