package ru.uvarov.students.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class PersonTest {

    private final String firstName = "testFirstName";
    private final String secondName = "testSecondName";

    @Test
    void getFirstName() {
        Person person = new Person(firstName, secondName);
        assertEquals(firstName, person.getFirstName());
    }

    @Test
    void getSecondName() {
        Person person = new Person(firstName, secondName);
        assertEquals(secondName, person.getSecondName());
    }
}