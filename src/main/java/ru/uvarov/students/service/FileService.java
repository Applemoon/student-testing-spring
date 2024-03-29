package ru.uvarov.students.service;

import org.springframework.stereotype.Service;
import ru.uvarov.students.component.ApplicationSettings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FileService {

    private final String fileName;

    public FileService(ApplicationSettings settings) {
        fileName = settings.getFilename();
    }

    public List<List<String>> readQuestions() {
        List<List<String>> records = new ArrayList<>();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        assert fileName != null;
        InputStream inputStream = classloader.getResourceAsStream(fileName);
        assert inputStream != null;
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        try (BufferedReader br = new BufferedReader(streamReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }
}
