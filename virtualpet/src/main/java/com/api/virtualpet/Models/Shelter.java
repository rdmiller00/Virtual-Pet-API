package com.api.virtualpet.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "Shelter")
@Entity(name = "Shelter")
@NoArgsConstructor
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator", sequenceName = "SHELTER_SEQ", allocationSize = 1)
    @Column(nullable = false)
    private Integer id;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String shelterState;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String shelterName;

    public Shelter(Integer id, String shelterState, String shelterName) {
        this.id = id;
        this.shelterState = shelterState;
        this.shelterName = shelterName;
    }

    
}
