package com.api.virtualpet.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.virtualpet.Models.Pet;
import com.api.virtualpet.Repositories.PetRepository;
import com.api.virtualpet.Repositories.ShelterRepository;

import jakarta.persistence.EntityNotFoundException;;

@Controller
public class PetController {
    @Autowired
    PetRepository petRepository;
    @Autowired
    ShelterRepository shelterRepository;

    @GetMapping("/api/pets")
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = petRepository.findAll();
        if (pets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(pets, HttpStatus.OK);
        }
    }

    @GetMapping("/api/shelter/{shelterId}/pets")
    public ResponseEntity<List<Pet>> getAllPetsByShelterId(@PathVariable Integer shelterId) {
        if (!shelterRepository.existsById(shelterId)) {
            throw new EntityNotFoundException("Shelter With ID: " + shelterId + " NotFound!");
        }

        List<Pet> pets = shelterRepository.getByShelterId(shelterId);
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/api/shelter/{shelterId}/{petType}")
    public ResponseEntity<List<Pet>> getPetsByShelterId(@PathVariable("shelterId") Integer shelterId, @PathVariable("petType") String petType) {
        List<Pet> pets = petRepository.findByPetTypeAndShelterId(petType, shelterId);

        if (pets.isEmpty()) {
            throw new EntityNotFoundException("There are currently no " + petType + "s in the shelter with ID: " + shelterId);
        }

        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/api/{petType}/{breed}")
    public ResponseEntity<List<Pet>> getPetsByBreed(@PathVariable("petType") String petType ,@PathVariable("breed") String breed) {
        List<Pet> pets = petRepository.findByBreed(breed);

        if (pets.isEmpty()) {
            throw new EntityNotFoundException("There are currently no " + breed + " " + petType + "s in our network of shelters");
        }

        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @PostMapping("/api/shelter/{shelterId}/pets")
    public ResponseEntity<Pet> createDog(@PathVariable(value = "shelterId") Integer shelterId,
            @RequestBody Pet petRequest) {
        Pet pet = shelterRepository.findById(shelterId).map(shelter -> {
            petRequest.setShelter(shelter);
            return petRepository.save(petRequest);
        }).orElseThrow(() -> new EntityNotFoundException("Shelter with ID: " + shelterId + " Not Found"));

        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

}
