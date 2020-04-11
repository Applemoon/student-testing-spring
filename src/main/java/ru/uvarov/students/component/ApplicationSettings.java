package ru.uvarov.students.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@ConfigurationProperties("questions")
public class ApplicationSettings {
    private String filename;
    private Locale locale;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(String localeStr) {
        this.locale = new Locale(localeStr);
    }
}
