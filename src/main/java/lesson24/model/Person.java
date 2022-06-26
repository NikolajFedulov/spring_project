package lesson24.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table
public class Person {

    @Id
    @Column("person_id")
    private int personID;

    @Column("person_name")
    private String personName;

    @Column("person_surname")
    private String personSurname;

    @Column("person_age")
    private int personAge;

    @Column("person_gender")
    private Gender gender;

    public Person() {
    }

    public Person(int personID, String personName, String personSurname, int personAge, Gender gender) {
        this.personID = personID;
        this.personName = personName;
        this.personSurname = personSurname;
        this.personAge = personAge;
        this.gender = gender;


    }

    public int getPersonID() {
        return personID;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public int getPersonAge() {
        return personAge;
    }

    public Gender getGender() {
        return gender;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPersonSurname(String personSurname) {
        this.personSurname = personSurname;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return this.personID == person.personID &&
                this.personAge == person.personAge &&
                this.personName.equalsIgnoreCase(person.personName) &&
                this.personSurname.equalsIgnoreCase(person.personSurname) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personID, personName, personSurname, personAge, gender);
    }
}
