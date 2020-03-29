package ru.uvarov.students.dao;

import ru.otus.spring01.domain.Person;

public class PersonDaoSimple implements PersonDao {
    private int defaultAge;

    public void setDefaultAge(int defaultAge) {
        this.defaultAge = defaultAge;
    }

    public Person findByName(String name) {
        return new Person(name, defaultAge);
    }
}
