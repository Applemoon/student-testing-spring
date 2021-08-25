package ru.uvarov.students.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Person {

    String firstName;
    String secondName;

    public String toString() {
        return String.format("%s %s", firstName, secondName);
    }
}
