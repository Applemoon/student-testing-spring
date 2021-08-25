package ru.uvarov.students.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Question {

    String questionText;
    List<String> answers;
    Integer rightAnswer;
}
