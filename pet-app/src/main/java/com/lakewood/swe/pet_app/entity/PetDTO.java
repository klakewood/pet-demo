package com.lakewood.swe.pet_app.entity;

public record PetDTO(String name, Double weight, String breed, Boolean isVaccinated, Integer trainingLevel) {
}
