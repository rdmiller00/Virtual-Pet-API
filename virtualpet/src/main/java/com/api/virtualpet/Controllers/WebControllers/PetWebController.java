package com.api.virtualpet.Controllers.WebControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.api.virtualpet.Models.Pet;
import com.api.virtualpet.Repositories.PetRepository;

public class PetWebController {
    @Autowired
    PetRepository dogRepository;

    @GetMapping("/api/shelter/{animalType}")
    public String displayDogs(Model model) {
        List<Dog> dogs = dogRepository.findAll();
        model.addAttribute("dog", dogs);
        return "dog";
    }
}
