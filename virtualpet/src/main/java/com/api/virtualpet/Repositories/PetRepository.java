package com.api.virtualpet.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.virtualpet.Models.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer>{
    List <Pet> getByPetId(Integer petId);

    List<Pet> findByBreed(String breed);
}
