package lesson24.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table
public class Animal {

    @Id
    @Column("animal_id")
    private int animalID;

    private Species species;

    @Column("animal_gender")
    private Gender animalGender;

    @Column("animal_age")
    private int animalAge;

    @Column("animal_name")
    private String animalName;


    public Animal(){}

    public Animal(int animalID, Species species, Gender animalGender, int animalAge, String animalName) {
        this.animalID = animalID;
        this.animalGender = animalGender;
        this.animalAge = animalAge;
        this.animalName = animalName;
        this.species = species;
    }

    public int getAnimalID() {
        return animalID;
    }

    public Gender getAnimalGender() {
        return animalGender;
    }

    public int getAnimalAge() {
        return animalAge;
    }

    public String getAnimalName() {
        return animalName;
    }


    public Species getSpecies() {
        return species;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    public void setAnimalGender(Gender animalGender) {
        this.animalGender = animalGender;
    }

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return this.animalID == animal.animalID &&
                this.animalAge == animal.animalAge &&
                this.species == animal.species &&
                this.animalGender == animal.animalGender &&
                this.animalName.equalsIgnoreCase(animal.animalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalID, species, animalGender, animalAge, animalName);
    }
}
