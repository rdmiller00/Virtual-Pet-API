package com.api.virtualpet.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.virtualpet.Models.Shelter;
import com.api.virtualpet.Repositories.ShelterRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController

public class ShelterController {
    @Autowired
    ShelterRepository shelterRepository;

    @GetMapping("/api/shelters")
    public ResponseEntity<List<Shelter>> getAllShelters() {
        List<Shelter> shelters = shelterRepository.findAll();

        if (shelters.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Shelter>>(shelters, HttpStatus.OK);
        }
    }

    @GetMapping("/api/shelter/{id}")
    public ResponseEntity<Shelter> getShelterById(@PathVariable("id") Integer id) {
        Optional<Shelter> shelter = shelterRepository.findById(id);

        if (!shelter.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(shelter.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/api/shelters")
    public ResponseEntity<Shelter> createShelter(@RequestBody Shelter shelter) {
        Shelter _shelter = shelterRepository
        .save(new Shelter(shelter.getShelterState(), shelter.getShelterName()));
        
        return new ResponseEntity<Shelter>(HttpStatus.CREATED);
    }
    
}
