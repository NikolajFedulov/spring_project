package lesson24.model;


public class Animal {

    private int animalID;
    private Species species;
    private Gender animalGender;
    private int animalAge;
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
}
