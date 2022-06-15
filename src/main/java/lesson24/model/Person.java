package lesson24.model;

public class Person {

    private int personID;
    private String personName;
    private String personSurname;
    private int personAge;
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
}
