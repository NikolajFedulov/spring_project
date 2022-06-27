package lesson24.service;

import lesson24.model.Animal;
import lesson24.model.Gender;
import lesson24.model.Species;
import lesson24.repository.AnimalRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;


class AnimalServiceTest {

    private final AnimalRepository animalRepository = Mockito.mock(AnimalRepository.class);
    private final AnimalService animalService = new AnimalService(animalRepository);

    private final Animal zoe = new Animal(
            1,
            Species.DOG,
            Gender.FEMALE,
            13,
            "Zoe"
    );
    private final Animal fredricka = new Animal(
            2,
            Species.DOG,
            Gender.FEMALE,
            0,
            "Fredricka"
    );

    @Test
    void getAnimal() {
        Mockito.when(animalRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(zoe));
        Assertions.assertEquals(zoe, animalService.getAnimal(100000000).orElse(null));  // happy flow

        Mockito.when(animalRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        Assertions.assertNull(animalService.getAnimal(100000000).orElse(null));         // not found by id
    }

    @Test
    void addAnimal() {
        Mockito.when(animalRepository.animalIsExists(Mockito.any(), Mockito.any(), Mockito.anyInt(), Mockito.anyString()))
                .thenReturn(null).thenReturn(zoe);
        Assertions.assertEquals(zoe, animalService.addAnimal(fredricka));   // happy flow

        Mockito.when(animalRepository.animalIsExists(Mockito.any(), Mockito.any(), Mockito.anyInt(), Mockito.anyString()))
                .thenReturn(zoe);
        Assertions.assertNull(animalService.addAnimal(fredricka));          // this animal already exists
    }

    @Test
    void updateAnimal() {
        Mockito.when(animalRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(zoe));
        Mockito.when(animalRepository.animalIsExists(Mockito.any(), Mockito.any(), Mockito.anyInt(), Mockito.anyString()))
                .thenReturn(null);
        Assertions.assertEquals(zoe, animalService.updateAnimal(fredricka));    // happy flow

        Mockito.when(animalRepository.animalIsExists(Mockito.any(), Mockito.any(), Mockito.anyInt(), Mockito.anyString()))
                .thenReturn(fredricka);
        Assertions.assertNull(animalService.updateAnimal(fredricka));           // this animal already exists
    }

    @Test
    void removeAnimal() {
        Mockito.when(animalRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(zoe));
        Assertions.assertEquals(zoe, animalService.removeAnimal(10000000)); // happy flow

        Mockito.when(animalRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        Assertions.assertNull(animalService.removeAnimal(10000000));        // not found by id
    }
}