package com.api.virtualpet.Controllers.WebControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.api.virtualpet.Models.Shelter;
import com.api.virtualpet.Repositories.ShelterRepository;

@Controller
public class ShelterWebController {
    @Autowired
    ShelterRepository shelterRepository;

    @GetMapping("/shelters")
    public String displayShelters(@ModelAttribute("shelters") Shelter shelter, Model model) {
        List<Shelter> shelters = shelterRepository.findAll();

        model.addAttribute("shelters", shelters);
        model.addAttribute("shelter", shelter);
        return "shelters";
    } 

    @PostMapping("/shelters")
    public String submitForm(@ModelAttribute("shelters") Shelter shelter, Model model) {
        shelterRepository.save(shelter);
        List<Shelter>shelters = shelterRepository.findAll();

        model.addAttribute("shelters", shelters);
        model.addAttribute("shelter", shelter);
        return "shelters";
    }
}
