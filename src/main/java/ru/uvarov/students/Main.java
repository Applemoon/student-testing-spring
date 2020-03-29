package ru.uvarov.students;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.uvarov.students.service.IOService;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        IOService ioService = context.getBean(IOService.class);
        ioService.askName();
        ioService.sayHello();
        ioService.startTesting();
        ioService.printResults();
    }
}

// Программа по проведению тестирования студентов
// В ресурсах хранятся вопросы и различные ответы к ним в виде CSV файла (5 вопрсов). Программа должна спросить у
// пользователя фамилию и имя, спросить 5 вопросов из CSV-файла и вывести результат тестирования.
// Все сервисы в программе должны решать строго определённую задачу. Зависимости должны быть настроены в
// IoC контейнере.