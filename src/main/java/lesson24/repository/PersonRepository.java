package lesson24.repository;

import lesson24.model.Gender;
import lesson24.model.Person;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Modifying
    @Query("INSERT INTO public.person(person_name, person_surname, person_age, person_gender) " +
            "VALUES (:1, :2, :3, :4::gender)")
    public void addPerson(
            @Param("1") String personName,
            @Param("2") String personSurname,
            @Param("3") int personAge,
            @Param("4") Gender personGender
            );

    @Query("SELECT * FROM person WHERE person_name ILIKE :1 AND person_surname ILIKE :2 " +
            "AND person_age = :3 AND person_gender = :4::gender")
    public Person personIsExists(
            @Param("1") String personName,
            @Param("2") String personSurname,
            @Param("3") int personAge,
            @Param("4") Gender personGender
    );

    @Modifying
    @Query("UPDATE person SET person_name = :1, person_surname = :2, person_age = :3, " +
            "person_gender = :4::gender WHERE person_id = :5")
    public void updatePerson(
            @Param("1") String personName,
            @Param("2") String personSurname,
            @Param("3") int personAge,
            @Param("4") Gender personGender,
            @Param("5") Integer personID
    );
}
