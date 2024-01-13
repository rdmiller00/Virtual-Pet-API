package com.api.virtualpet.Models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table (name = "Pet")
@Entity (name = "Pet")
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator", sequenceName = "PET_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "shelter_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Shelter shelter;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String petName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String petType;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String breed;

    @Column(nullable = false, columnDefinition = "TEXT")
    private Integer hungerLevel;

    @Column(nullable = false, columnDefinition = "TEXT")
    private Integer thirstLevel;

    public Pet(Integer id, Shelter shelter, String petName, String petType, String breed, Integer hungerLevel,
            Integer thirstLevel) {
        this.shelter = shelter;
        this.petName = petName;
        this.petType = petType;
        this.breed = breed;
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
    }

    
}
