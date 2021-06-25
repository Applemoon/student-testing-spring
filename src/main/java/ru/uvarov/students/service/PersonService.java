package ru.uvarov.students.service;

import org.springframework.stereotype.Service;
import ru.uvarov.students.domain.Person;

@Service
public class PersonService {

    private Person person;

    public void saveName(String firstName, String secondName) {
        person = new Person(firstName, secondName);
    }

    public String getName() {
        return person.toString();
    }
}
