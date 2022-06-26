package lesson24.controller;

import lesson24.model.Person;
import lesson24.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController()
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable int id) {
        Person person = personService.getPerson(id).orElse(null);
        if (person == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return person;
    }

    @PostMapping
    public Person updatePerson(@RequestBody Person person) {
        Person person1 = personService.updatePerson(person);
        if (person1 == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return person1;
    }

    @PutMapping
    public Person addPerson(@RequestBody Person person) {
        person = personService.addPerson(person);
        if (person == null) {
            throw new ResponseStatusException (HttpStatus.BAD_REQUEST);
        }
        return person;
    }

    @DeleteMapping("/{id}")
    public Person removePerson(@PathVariable int id) {
        Person person = personService.removePerson(id);
        if (person == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return person;
    }
}