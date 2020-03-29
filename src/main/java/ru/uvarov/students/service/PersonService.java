package ru.uvarov.students.service;

import ru.otus.spring01.domain.Person;

public interface PersonService {

    Person getByName(String name);
}
