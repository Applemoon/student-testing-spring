package ru.uvarov.students.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.uvarov.students.component.ApplicationSettings;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Service
public class IOService {

    private final PersonService personService;
    private final QuestionsService questionsService;
    private final MessageSource messageSource;
    private final Locale locale;
    private final Scanner scanner = new Scanner(System.in);

    public IOService(PersonService personService, QuestionsService questionsService, MessageSource messageSource,
                     ApplicationSettings settings) {
        this.personService = personService;
        this.questionsService = questionsService;
        this.messageSource = messageSource;
        this.locale = settings.getLocale();
    }

    public void askName() {
        System.out.print(messageSource.getMessage("enter.firstname", null, locale) + ": ");
        String firstName = scanner.nextLine();
        System.out.print(messageSource.getMessage("enter.secondname", null, locale) + ": ");
        String secondName = scanner.nextLine();

        personService.saveName(firstName, secondName);
    }

    public void sayHello() {
        System.out.println(messageSource.getMessage("hello.username", new String[] {personService.getName()}, locale));
    }

    public void startTesting() {
        final int totalQuestions = questionsService.getTotalQuestions();
        for (int questionNumber = 0; questionNumber < totalQuestions; questionNumber++) {
            String question = questionsService.getQuestion(questionNumber);
            System.out.println(messageSource.getMessage(
                    "question.number",
                    new String[] {String.valueOf(questionNumber + 1), question},
                    locale)
            );
            List<String> answers = questionsService.getAnswers(questionNumber);

            System.out.println(messageSource.getMessage("answers", null, locale));
            for (int i = 0; i < answers.size(); i++) {
                System.out.printf("%d: %s%n", i + 1, answers.get(i));
            }

            System.out.print(messageSource.getMessage("your.answer.number", null, locale) + ": ");

            boolean done = false;
            int answer = -1;
            while (!done) {
                try {
                    answer = Integer.parseInt(scanner.nextLine());
                    done = true;
                } catch (NumberFormatException e) {
                    System.out.print(messageSource.getMessage("parsing.error", null, locale) + ": ");
                }
            }
            questionsService.saveAnswer(answer, questionNumber);
            System.out.println();
        }
    }

    public void printResults() {
        final int result = questionsService.getResult();
        final int totalQuestions = questionsService.getTotalQuestions();
        System.out.println(messageSource.getMessage(
                "your.result",
                new String[] {personService.getName(), String.valueOf(result), String.valueOf(totalQuestions)},
                locale)
        );

        if (result == totalQuestions) {
            System.out.println(messageSource.getMessage("perfect", null, locale));
        }
    }
}
