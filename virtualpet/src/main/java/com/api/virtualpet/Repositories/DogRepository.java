package com.api.virtualpet.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.virtualpet.Models.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer>{
    List <Dog> getByPetId(Integer petId);
}
