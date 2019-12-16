package com.kkukielka.petcatalogueweb.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.kkukielka.petcatalogueweb.view.Views;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class OwnerDto {

    @JsonView(Views.Normal.class)
    private Long id;

    @JsonView(Views.Normal.class)
    private String name;

    @EqualsAndHashCode.Exclude
    @JsonView(Views.Owner.class)
    private Set<PetDto> pets = new HashSet<>();

}
