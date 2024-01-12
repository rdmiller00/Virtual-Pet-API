package com.api.virtualpet.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.virtualpet.Models.Pet;
import com.api.virtualpet.Models.Shelter;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Integer>{
    
    @Query("SELECT pet FROM Pet pet WHERE pet.shelter.id = :shelterId")
    List<Pet> getByShelterId(@Param("shelterId") Integer shelterId);
}