package ru.uvarov.students.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.uvarov.students.service.IOService;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventsCommands {

    private final IOService ioService;

    @ShellMethod(value = "Start command", key = {"s", "start"})
    public String start() {
        ioService.askName();
        ioService.sayHello();
        ioService.startTesting();
        ioService.printResults();
        return "";
    }
}
