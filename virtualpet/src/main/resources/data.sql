-- Create table for dogs
CREATE TABLE Dogs (
    petId INT PRIMARY KEY,
    dogName TEXT,
    dogBreed TEXT,
    dogAge INT,
    hungerLevel INT,
    thirstLevel INT
);

-- Insert 5 unique instances of dogs
INSERT INTO Dogs (petId, dogName, dogBreed, dogAge, hungerLevel, thirstLevel)
VALUES 
    (1, 'Buddy', 'Golden Retriever', 3, 50, 30),
    (2, 'Max', 'German Shepherd', 2, 40, 25),
    (3, 'Lucy', 'Labrador Retriever', 4, 60, 35),
    (4, 'Charlie', 'Poodle', 5, 45, 28),
    (5, 'Daisy', 'Beagle', 1, 30, 20);

-- Create table for cats
CREATE TABLE Cats (
    petId INT PRIMARY KEY,
    catName TEXT,
    catBreed TEXT,
    catAge INT,
    hungerLevel INT,
    thirstLevel INT
);

-- Insert 5 unique instances of cats
INSERT INTO Cats (petId, catName, catBreed, catAge, hungerLevel, thirstLevel)
VALUES 
    (6, 'Whiskers', 'Siamese', 2, 35, 25),
    (7, 'Mittens', 'Persian', 4, 55, 30),
    (8, 'Shadow', 'Maine Coon', 3, 45, 28),
    (9, 'Oliver', 'Bengal', 1, 30, 20),
    (10, 'Luna', 'Ragdoll', 5, 60, 35);

-- Create table for Shelter
CREATE TABLE Shelter (
    petId INT PRIMARY KEY DEFAULT generate_pet_id(),
    petType VARCHAR(10) NOT NULL CHECK (petType IN ('dog', 'cat')),
    petName TEXT,
    petBreed TEXT,
    petAge INT,
    hungerLevel INT,
    thirstLevel INT,
    CONSTRAINT fk_petId_dogs FOREIGN KEY (petId) REFERENCES Dogs(petId),
    CONSTRAINT fk_petId_cats FOREIGN KEY (petId) REFERENCES Cats(petId)
);

-- Create a sequence for generating petId
CREATE SEQUENCE pet_id_sequence START 11;

-- Function to generate next value from the sequence
CREATE OR REPLACE FUNCTION generate_pet_id()
RETURNS INT AS $$
BEGIN
    RETURN NEXTVAL('pet_id_sequence');
END;
$$ LANGUAGE plpgsql;

-- Set default for petId using the sequence
ALTER TABLE Shelter ALTER COLUMN petId SET DEFAULT generate_pet_id();
