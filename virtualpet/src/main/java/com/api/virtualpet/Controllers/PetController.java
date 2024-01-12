package com.api.virtualpet.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        List<Pet> dogs = petRepository.findAll();
        if (dogs.isEmpty()) {
            throw new EntityNotFoundException("There are currently no dogs in the shelter");
        }

        return new ResponseEntity<>(dogs, HttpStatus.OK);
    }

    @GetMapping("/api/{petType}/{breed}")
    public ResponseEntity<List<Dog>> getDogsByBreed(@PathVariable("breed") String breed) {
        List<Dog> dogs = dogRepository.findByBreed(breed); // does this List need to be an Optional? I could not get it to work with Optional

        if (dogs.isEmpty()) {
            throw new EntityNotFoundException("There are currently no " + breed + "s in the shelter");
        } 

        return new ResponseEntity<>(dogs, HttpStatus.OK);
    }

    // @PostMapping("/api/shelter/{petType}")
    // public ResponseEntity<Dog> createDog (@PathVariable(value = "petType") String petType
    // @RequestBody Dog

}
