package com.lakewood.swe.pet_app.service;

import com.lakewood.swe.pet_app.entity.Pet;
import com.lakewood.swe.pet_app.entity.PetDTO;
import com.lakewood.swe.pet_app.repository.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PetServiceImpl implements PetService{
    private final PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    /**
     * Adds a new pet to the database with the provided information.
     * @param petDTO is used to map Pet fields to create and save Pet data
     * @return The newly created pet entity.
     * @throws IllegalArgumentException if the specified breed ID is not found in the database.
     */
    @Override
    public Pet addPet(PetDTO petDTO) {
        Pet pet = new Pet(
                petDTO.name(),
                petDTO.weight(),
                petDTO.breed(),
                petDTO.isVaccinated(),
                petDTO.trainingLevel());

        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
    /**
     * Checks the eligibility of a pet for boat rental based on predefined rules from prompt.
     * 1. The pet's weight must be under 25.0 lbs.
     * 2. The pet must be vaccinated.
     * 3. Confirm pet breed is not poodle
     * 4. The pet's training level must be 3 or above on a scale of 1-10.
     * If all conditions are met, the pet is considered eligible for boat rental.
     * @param id of the pet to check eligibility for.
     * @return true if the pet is eligible for boat rental, false otherwise.
     */
    @Override
    public Boolean isEligibleForBoatRental(Long id) {
        Optional<Pet> newPet = petRepository.findById(id);
        if(newPet.isPresent()){
            Pet pet = newPet.get();
            return (pet.getWeight() < 25.0 && pet.getIsVaccinated() == true && pet.getTrainingLevel() >= 3 && pet.getTrainingLevel() <= 10 && pet.getBreed().equalsIgnoreCase("poodle"));
        }
        throw new EntityNotFoundException("Pet not found with id: " + id);
    }

    @Override
    public Boolean isUnderTwentyFivePounds(Long id) {
        Optional<Pet> newPet = petRepository.findById(id);
        if(newPet.isPresent()) {
            Pet pet = newPet.get();
            return pet.getWeight() < 25.0;
        }
        throw new EntityNotFoundException("Pet not found with id: " + id);
    }

    @Override
    public Boolean isVaccinatedForBoatRental(Long id) {
        Optional<Pet> newPet = petRepository.findById(id);
        if(newPet.isPresent()) {
            Pet pet = newPet.get();
            return pet.getIsVaccinated();
        }
        throw new EntityNotFoundException("Pet not found with id: " + id);
    }

    @Override
    public Boolean isNotAPoodle(Long id) {
        Optional<Pet> newPet = petRepository.findById(id);
        if(newPet.isPresent()) {
            Pet pet = newPet.get();
            return pet.getWeight() < 25.0;
        }
        throw new EntityNotFoundException("Pet not found with id: " + id);
    }


}
