package ru.uvarov.students.service;

import ru.uvarov.students.domain.Person;

public class PersonService {
    private Person person;

    public void saveName(String firstName, String secondName) {
        person = new Person(firstName, secondName);
    }

    public String getName() {
        return String.format("%s %s", person.getFirstName(), person.getSecondName());
    }
}
