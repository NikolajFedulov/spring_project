package lesson24.service;

import lesson24.model.Gender;
import lesson24.model.Person;
import lesson24.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;


class PersonServiceTest {

    private final PersonRepository personRepository = Mockito.mock(PersonRepository.class);
    private final PersonService personService = new PersonService(personRepository);

    private final Person susan = new Person(
            1,
            "Susan",
            "Shelton",
            25,
            Gender.FEMALE
    );
    private final Person gloria = new Person(
            2,
            "Gloria",
            "Singleton",
            30,
            Gender.FEMALE
    );

    @Test
    void getPerson() {
        Mockito.when(personRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(susan));   // happy flow
        Assertions.assertEquals(susan, personService.getPerson(1531453215).orElse(null));

        Mockito.when(personRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        Assertions.assertNull(personService.getPerson(1531453215).orElse(null));           // not found by id
    }

    @Test
    void addPerson() {
        Mockito.when(personRepository.personIsExists(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.any()))
                .thenReturn(null).thenReturn(susan);
        Assertions.assertEquals(susan, personService.addPerson(gloria));    // happy flow

        Mockito.when(personRepository.personIsExists(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.any()))
                .thenReturn(susan);
        Assertions.assertNull(personService.addPerson(gloria));             // this animal already exists
    }

    @Test
    void updatePerson() {
        Mockito.when(personRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(susan));
        Mockito.when(personRepository.personIsExists(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.any()))
                .thenReturn(null);
        Assertions.assertEquals(susan, personService.updatePerson(gloria)); // happy flow

        Mockito.when(personRepository.personIsExists(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.any()))
                .thenReturn(gloria);
        Assertions.assertNull(personService.updatePerson(gloria));          // this animal already exists
    }

    @Test
    void removePerson() {
        Mockito.when(personRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(susan));
        Assertions.assertEquals(susan, personService.removePerson(51543));  // happy flow

        Mockito.when(personRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        Assertions.assertNull(personService.removePerson(1654351));         // not found by id
    }
}