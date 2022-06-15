package lesson24.service;

import lesson24.model.Person;
import lesson24.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPerson(int id) {
        return personRepository.getPerson(id);
    }

    public Person addPerson(Person person) {
        return personRepository.addPerson(person);
    }

    public Person updatePerson(Person person) {
        return personRepository.updatePerson(person);
    }

    public Person removePerson(int id) {
        return personRepository.removePerson(id);
    }
}
