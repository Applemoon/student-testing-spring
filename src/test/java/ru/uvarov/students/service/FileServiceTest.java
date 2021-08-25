package ru.uvarov.students.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FileServiceTest {

    @Autowired
    FileService fileService;

    @Test
    void readQuestions() {
        assertEquals(List.of(List.of("1", "1", "2", "1"), List.of("2", "1", "2", "2")), fileService.readQuestions());
    }
}