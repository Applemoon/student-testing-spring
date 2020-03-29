package ru.uvarov.students.service;

import java.util.List;
import java.util.Scanner;

public class IOService {
    private final PersonService personService;
    private final QuestionsService questionsService;
    private final Scanner scanner = new Scanner(System.in);

    IOService(PersonService personService, QuestionsService questionsService) {
        this.personService = personService;
        this.questionsService = questionsService;
    }

    public void askName() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter second name: ");
        String secondName = scanner.nextLine();

        personService.saveName(firstName, secondName);
    }

    public void sayHello() {
        System.out.println(String.format("Hello, %s", personService.getName()));
    }

    public void startTesting() {
        final int totalQuestions = this.questionsService.getTotalQuestions();
        for (int questionNumber = 0; questionNumber < totalQuestions; questionNumber++) {
            String question = this.questionsService.getQuestion(questionNumber);
            System.out.println(String.format("Question %d: %s", questionNumber + 1, question));
            List<String> answers = this.questionsService.getAnswers(questionNumber);

            System.out.println("Answers:");
            for (int i = 0; i < answers.size(); i++) {
                System.out.println(String.format("%d: %s", i + 1, answers.get(i)));
            }

            System.out.print("Your answer number: ");
            String answerStr = scanner.nextLine();
            boolean done = false;
            int answer = -1;
            while (!done) {
                try {
                    answer = Integer.parseInt(answerStr);
                    done = true;
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing number from input, try again");
                }
            }
            this.questionsService.saveAnswer(answer, questionNumber);
            System.out.println();
        }
    }

    public void printResults() {
        final int result = this.questionsService.getResult();
        final int totalQuestions = this.questionsService.getTotalQuestions();
        System.out.println(String.format("%s, your result: %d / %d", personService.getName(), result, totalQuestions));
        if (result == totalQuestions) {
            System.out.println("Perfect!");
        }
    }
}
