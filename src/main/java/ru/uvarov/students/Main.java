package ru.uvarov.students;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        PersonService service = context.getBean(PersonService.class);
        Person ivan = service.getByName("Ivan");
        System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());
    }
}

// Программа по проведению тестирования студентов
// В ресурсах хранятся вопросы и различные ответы к ним в виде CSV файла (5 вопрсов). Программа должна спросить у
// пользователя фамилию и имя, спросить 5 вопросов из CSV-файла и вывести результат тестирования.
// Все сервисы в программе должны решать строго определённую задачу. Зависимости должны быть настроены в
// IoC контейнере.