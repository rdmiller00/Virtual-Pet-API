package com.api.virtualpet.Controllers.WebControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.api.virtualpet.Models.Pet;
import com.api.virtualpet.Repositories.PetRepository;

@Controller
public class PetWebController {
    @Autowired
    PetRepository petRepository;

    @GetMapping("/shelters/dogs")
    public String displayDogs(Model model) {
        List<Pet> dogs = petRepository.findByPetType("Dog");
        model.addAttribute("dogs", dogs);
        return "dogs";
    }

    @GetMapping("/shelters/cats")
    public String displayCats(Model model) {
        List<Pet> cats = petRepository.findByPetType("Cat");
        model.addAttribute("cats", cats);
        return "cats";
    }

    @GetMapping("/shelters/pets")
    public String displayAllPets(Model model) {
        List<Pet> allPets = petRepository.findAll();
        model.addAttribute("allPets", allPets);
        return "allPets";
    }

    @PostMapping("/pets")
    public String createPet(@ModelAttribute("pet") Pet pet, Model model) {
        petRepository.save(pet);
        List<Pet> pets = petRepository.findAll();

        model.addAttribute("pets", pets);
        model.addAttribute("pet", pet);
        return "pets";
    }
}
