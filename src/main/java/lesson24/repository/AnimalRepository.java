package lesson24.repository;

import lesson24.model.Animal;
import lesson24.model.Gender;
import lesson24.model.Species;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalRepository {

    private List<Animal> animalList = new ArrayList<>();

    public AnimalRepository(){
        int index;
        index = animalList.size();
        animalList.add(new Animal(index, Species.CAT, Gender.FEMALE, 3, "Sakura"));
        index = animalList.size();
        animalList.add(new Animal(index, Species.CAT, Gender.MALE, 1, "Greedo"));
        index = animalList.size();
        animalList.add(new Animal(index, Species.CAT, Gender.MALE, 1, "Jay"));
        index = animalList.size();
        animalList.add(new Animal(index, Species.CAT, Gender.FEMALE, 1, "MIla"));
        index = animalList.size();
        animalList.add(new Animal(index, Species.DOG, Gender.FEMALE, 2,"Willow"));
        index = animalList.size();
        animalList.add(new Animal(index, Species.DOG, Gender.FEMALE, 3, "Snow White"));
        index = animalList.size();
        animalList.add(new Animal(index, Species.DOG, Gender.MALE, 6, "Ryder"));
        index = animalList.size();
        animalList.add(new Animal(index, Species.DOG, Gender.MALE, 3, "Remi"));
    }

    public Animal getAnimal(int id) {
        try {
            return animalList.get(id);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Animal addAnimal(@NotNull Animal animal) {
        int index = getAnimal(animalList.size()-1).getAnimalID()+1;
        animal.setAnimalID(index);
        animalList.add(animal);
        return getAnimal(animalList.size()-1);
    }

    public Animal updateAnimal(@NotNull Animal animal) {
        int index = animal.getAnimalID();
        try {
            return animalList.set(index, animal);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Animal removeAnimal(int id) {
        try {
            return animalList.remove(id);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}