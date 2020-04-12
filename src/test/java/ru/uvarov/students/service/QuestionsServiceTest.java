package ru.uvarov.students.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class QuestionsServiceTest {
    @Autowired QuestionsService service;

    @Test
    void getResult() {
        assertEquals(4, getTestQuestionService().getResult());
    }

    @Test
    void getTotalQuestions() {
        assertEquals(4, getTestQuestionService().getTotalQuestions());
    }

    @Test
    void getQuestion() {
        QuestionsService service = getTestQuestionService();
        assertEquals("q1?", service.getQuestion(0));
        assertEquals("q2?", service.getQuestion(1));
        assertEquals("q3?", service.getQuestion(2));
        assertEquals("q4?", service.getQuestion(3));
    }

    @Test
    void getAnswers() {
        QuestionsService service = getTestQuestionService();
        assertEquals(Arrays.asList("a", "b", "c", "d"), service.getAnswers(0));
        assertEquals(Arrays.asList("a", "b", "c", "d"), service.getAnswers(1));
        assertEquals(Arrays.asList("a", "b", "c", "d"), service.getAnswers(2));
        assertEquals(Arrays.asList("a", "b", "c", "d"), service.getAnswers(3));
    }

    private QuestionsService getTestQuestionService() {
        FileService fileService = Mockito.mock(FileService.class);
        List<List<String>> answers = Arrays.asList(
                Arrays.asList("q1?", "a", "b", "c", "d", "1"),
                Arrays.asList("q2?", "a", "b", "c", "d", "2"),
                Arrays.asList("q3?", "a", "b", "c", "d", "3"),
                Arrays.asList("q4?", "a", "b", "c", "d", "4"));
        Mockito.when(fileService.readQuestions()).thenReturn(answers);
        QuestionsService questionsService = new QuestionsService(fileService);

        questionsService.saveAnswer(1, 0);
        questionsService.saveAnswer(2, 1);
        questionsService.saveAnswer(3, 2);
        questionsService.saveAnswer(4, 3);

        return questionsService;
    }
}