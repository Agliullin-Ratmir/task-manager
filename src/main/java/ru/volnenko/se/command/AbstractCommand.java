package ru.volnenko.se.command;

import ru.volnenko.se.controller.Bootstrap;

import java.io.IOException;

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

}
