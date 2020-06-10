package ru.volnenko.se.command;

import org.springframework.beans.factory.annotation.Autowired;
import ru.volnenko.se.controller.Bootstrap;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Denis Volnenko
 */
public abstract class AbstractCommand {

    protected Bootstrap bootstrap;

    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public abstract void execute() throws Exception;

    public abstract String command();

    public abstract String description();

    public String nextLine() {
        return bootstrap.getScanner().nextLine();
    }

    public Integer nextInteger() {
        final String value = nextLine();
        if (value == null || value.isEmpty()) return null;
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return null;
        }
    }

}
