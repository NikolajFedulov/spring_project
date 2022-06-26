package lesson24.repository;

import lesson24.model.Animal;
import lesson24.model.Gender;
import lesson24.model.Species;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer> {

    @Modifying
    @Query("INSERT INTO public.animal(species, animal_gender, animal_age, animal_name) " +
            "VALUES (:1::species, :2::gender, :3, :4)")
    public void addAnimal(
            @Param("1") Species species,
            @Param("2") Gender gender,
            @Param("3") int age,
            @Param("4") String name
    );

    @Query("SELECT * FROM animal WHERE species = :1::species AND animal_gender = :2::gender " +
            "AND animal_age = :3 AND animal_name ILIKE :4")
    public Animal animalIsExists(
            @Param("1") Species species,
            @Param("2") Gender gender,
            @Param("3") int age,
            @Param("4") String name
    );

//    @Query("SELECT * FROM animal WHERE animal_id = (SELECT MAX(animal_id) FROM animal)")
//    public Animal getAnimalByMaxID();

//    @Query("SELECT MAX(animal_id) FROM animal")
//    public Integer maxIDAnimal();

    @Modifying
    @Query("UPDATE animal SET species = :1::species, animal_gender = :2::gender, animal_age = :3, " +
            "animal_name = :4 WHERE animal_id = :5")
    public void updateAnimal(
            @Param("1") Species species,
            @Param("2") Gender gender,
            @Param("3") int age,
            @Param("4") String name,
            @Param("5") Integer animalID
    );
}
