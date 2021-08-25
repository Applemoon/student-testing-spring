package ru.uvarov.students.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class QuestionsServiceTest {

    @MockBean
    FileService fileService;

    @Test
    void getTotalQuestions() {
        assertEquals(1, getTestQuestionService().getTotalQuestions());
    }

    @Test
    void getTotalQuestionsFromEmpty() {
        assertEquals(0, new QuestionsService(Collections.emptyList()).getTotalQuestions());
    }

    @Test
    void getQuestion() {
        assertEquals("q1?", getTestQuestionService().getQuestion(0).getQuestionText());
    }

    @Test
    void saveAnswer() {
        QuestionsService service = getTestQuestionService();
        service.saveAnswer(1, 0);
        assertEquals(1, service.getResult());
    }

    private QuestionsService getTestQuestionService() {
        List<List<String>> answers = Collections.singletonList(
                Arrays.asList("q1?", "a", "b", "c", "d", "1")
        );
        given(fileService.readQuestions()).willReturn(answers);

        return new QuestionsService(fileService.readQuestions());
    }
}