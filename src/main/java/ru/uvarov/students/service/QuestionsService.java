package ru.uvarov.students.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionsService {
    private final List<String> questions = new ArrayList<>();
    private final List<List<String>> answers = new ArrayList<>();
    private final List<Integer> rightAnswers = new ArrayList<>();
    private int rightAnswersCount = 0;

    QuestionsService(FileService fileService) {
        parseQuestions(fileService.readQuestions());
    }

    public int getResult() {
        return rightAnswersCount;
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public String getQuestion(int number) {
        return questions.get(number);
    }

    public List<String> getAnswers(int number) {
        return answers.get(number);
    }

    public void saveAnswer(int answer, int number) {
        if (rightAnswers.get(number).equals(answer)) {
            rightAnswersCount += 1;
        }
    }

    private void parseQuestions(List<List<String>> questionsStrings) {
        for (List<String> string: questionsStrings) {
            int size = string.size();
            questions.add(string.get(0));
            answers.add(string.subList(1, size - 1));
            int rightAnswer = Integer.parseInt(string.get(size - 1));
            rightAnswers.add(rightAnswer);
        }
    }
}
