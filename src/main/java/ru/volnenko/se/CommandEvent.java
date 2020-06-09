package ru.volnenko.se;

import org.springframework.context.ApplicationEvent;

public class CommandEvent extends ApplicationEvent {
    private String command;

    public CommandEvent(Object source, String command) {
        super(source);
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
