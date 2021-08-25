package ru.uvarov.students.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@ConfigurationProperties("questions")
@Getter
@Setter
public class ApplicationSettings {

    private String filename;
    private Locale locale;
}
