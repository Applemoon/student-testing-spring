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
        assertEquals(firstName, getTestPerson().getFirstName());
    }

    @Test
    void getSecondName() {
        assertEquals(secondName, getTestPerson().getSecondName());
    }

    private Person getTestPerson() {
        return new Person(firstName, secondName);
    }
}