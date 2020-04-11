package ru.uvarov.students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.uvarov.students.service.IOService;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        IOService ioService = context.getBean(IOService.class);

        ioService.askName();
        ioService.sayHello();
        ioService.startTesting();
        ioService.printResults();
    }


    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("i18n/bundle");
        messageSource.setDefaultEncoding("UTF8");
        return messageSource;
    }
}

// Программа по проведению тестирования студентов
// В ресурсах хранятся вопросы и различные ответы к ним в виде CSV файла (5 вопрсов). Программа должна спросить у
// пользователя фамилию и имя, спросить 5 вопросов из CSV-файла и вывести результат тестирования.
// Все сервисы в программе должны решать строго определённую задачу. Зависимости должны быть настроены в
// IoC контейнере.