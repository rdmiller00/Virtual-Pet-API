CREATE TABLE shelter (id INTEGER NOT NULL AUTO_INCREMENT, shelter_state TEXT NOT NULL, shelter_name TEXT NOT NULL, PRIMARY KEY (id));
CREATE TABLE pet (id INTEGER NOT NULL AUTO_INCREMENT, shelter_id INTEGER NOT NULL, pet_name TEXT NOT NULL, pet_type TEXT NOT NULL, breed TEXT NOT NULL,  hunger_level INTEGER NOT NULL, thirst_level INTEGER NOT NULL, PRIMARY KEY (id));

CREATE SEQUENCE SHELTER_SEQ START WITH 3 INCREMENT BY 1;
CREATE SEQUENCE PET_SEQ START WITH 7 INCREMENT BY 1;

INSERT INTO shelter (id, shelter_state, shelter_name) VALUES (1, 'Ohio', 'Happy Hearts Pet Shelter');
INSERT INTO shelter (id, shelter_state, shelter_name) VALUES (2, 'Florida', 'Florida Friends Shelter');

INSERT INTO pet (id, shelter_id, pet_name, pet_type, breed, hunger_level, thirst_level) VALUES (1, 1, 'Sparky', 'dog', 'Golden Retriever', 30, 30);
INSERT INTO pet (id, shelter_id, pet_name, pet_type, breed, hunger_level, thirst_level) VALUES (2, 2, 'Buster', 'dog', 'German Shepherd', 30, 30 );
INSERT INTO pet (id, shelter_id, pet_name, pet_type, breed, hunger_level, thirst_level) VALUES (3, 1, 'Kitty', 'cat', 'brown', 25, 25);
INSERT INTO pet (id, shelter_id, pet_name, pet_type, breed, hunger_level, thirst_level) VALUES (4, 2, 'Fluffy', 'cat', 'white', 25, 25);
INSERT INTO pet (id, shelter_id, pet_name, pet_type, breed, hunger_level, thirst_level) VALUES (5, 1, 'Charlie', 'dog', 'Labrador Retriever', 35, 35);
INSERT INTO pet (id, shelter_id, pet_name, pet_type, breed, hunger_level, thirst_level) VALUES (6, 2, 'Mittens', 'cat', 'black', 28, 28);
