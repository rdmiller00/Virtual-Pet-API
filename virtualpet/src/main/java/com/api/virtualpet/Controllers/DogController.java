package com.api.virtualpet.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.virtualpet.Repositories.DogRepository;
import com.api.virtualpet.Repositories.ShelterRepository;

@RestController
public class DogController {
    @Autowired
    DogRepository dogRepository;
    @Autowired
    ShelterRepository shelterRepository;
}

@GetMapping("/api/shelter/{animalType}")
