package com.lakewood.swe.pet_app.controller;

import com.lakewood.swe.pet_app.entity.Pet;
import com.lakewood.swe.pet_app.entity.PetDTO;
import com.lakewood.swe.pet_app.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PetController {

    private final PetService petService;
    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }


   @QueryMapping
    List<Pet> getAllPetsHandler(){
        return petService.getAllPets();
    }

    @MutationMapping
    Pet savePetHandler(@Argument PetDTO petDTO){
        return petService.addPet(petDTO);
    }
    @QueryMapping
    Boolean isUnderTwentyFivePoundsForBoatRental(@Argument Long id){
        return petService.isUnderTwentyFivePounds(id);
    }
    @QueryMapping
    Boolean petIsVaccinatedForBoatRental(@Argument Long id){
        return petService.isVaccinatedForBoatRental(id);
    }
    Boolean petIsNotAPoodleForBoatRental(@Argument Long id){
        return petService.isNotAPoodle(id);
    }
    @QueryMapping
    Boolean  petIsEligibleForBoatRental(@Argument Long id){
        return petService.isEligibleForBoatRental(id);
    }

}
