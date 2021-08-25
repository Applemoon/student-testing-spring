package ru.uvarov.students.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.uvarov.students.domain.Question;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionsService {

    private final List<Question> questions = new ArrayList<>();
    @Getter
    private int result = 0;

    public QuestionsService(List<List<String>> questionsStrings) {
        for (List<String> string : questionsStrings) {
            questions.add(
                    Question.builder()
                            .questionText(string.get(0))
                            .answers(string.subList(1, string.size() - 1))
                            .rightAnswer(Integer.valueOf(string.get(string.size() - 1)))
                            .build()
            );
        }
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public Question getQuestion(int number) {
        return questions.get(number);
    }

    public void saveAnswer(int answer, int number) {
        if (answer == questions.get(number).getRightAnswer()) {
            result += 1;
        }
    }
}
