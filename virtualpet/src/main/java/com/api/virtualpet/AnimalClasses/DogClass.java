package com.api.virtualpet.AnimalClasses;

public class DogClass {
// Attributes-----?petId?, name, breed, age, hunger, thirst--------------------------------------------------------------------------------------------|
// private int petId;
private String name;
private String breed;
private int age;
private int hunger;
private int thirst;

// Constructors-----------------------------------------------------------------------------------------------|
public DogClass(String name, String breed, int age, int hunger, int thirst) {
    // this.petId = petId;
    this.name = name;
    this.breed = breed;
    this.age = age;
    this.hunger = hunger;
    this.thirst = thirst;
}

// Getters and Setters----------------------------------------------------------------------------------------|
// public int getPetId() {
//     return petId;
// }
// public void setPetId(int petId) {
//     this.petId = petId;
// }

public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}

public String getBreed() {
    return breed;
}
public void setBreed(String breed) {
    this.breed = breed;
}

public int getAge() {
    return age;
}
public void setAge(int age) {
    this.age = age;
}

public int getHunger() {
    return hunger;
}
public void setHunger(int hunger) {
    this.hunger = hunger;
}

public int getThirst() {
    return thirst;
}
public void setThirst(int thirst) {
    this.thirst = thirst;
}

    




}
