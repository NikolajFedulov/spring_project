package lesson24.repository;

import lesson24.model.Gender;
import lesson24.model.Person;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    private List<Person> personList = new ArrayList<>();

    public PersonRepository() {
        int index;
        index = personList.size();
        personList.add( new Person(index, "Robert", "Price", 16, Gender.MALE));
        index = personList.size();
        personList.add( new Person(index, "Mary", "Wilson", 20, Gender.FEMALE));
        index = personList.size();
        personList.add( new Person(index, "Daniel", "Elliott", 27, Gender.MALE));
        index = personList.size();
        personList.add( new Person(index, "Eric", "Grant", 23, Gender.MALE));
    }

    public Person getPerson(int id) {
        try {
            return personList.get(id);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Person addPerson(@NotNull Person person) {
        int index = getPerson(personList.size()-1).getPersonID()+1;
        person.setPersonID(index);
        personList.add(person);
        return getPerson(personList.size()-1);
    }

    public Person updatePerson(@NotNull Person person) {
        int index = person.getPersonID();
        try {
            return personList.set(index, person);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Person removePerson(int id) {
        try {
            return personList.remove(id);
        }
        catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
