package com.lakewood.swe.pet_app.service;

import com.lakewood.swe.pet_app.entity.Pet;
import com.lakewood.swe.pet_app.entity.PetDTO;

import java.util.List;

public interface PetService {
    Pet addPet(PetDTO petDTO);
    List<Pet> getAllPets();
    Boolean isEligibleForBoatRental(Long Id);
    Boolean isUnderTwentyFivePounds(Long id);
    Boolean isVaccinatedForBoatRental(Long id);
    Boolean isNotAPoodle(Long id);
}
