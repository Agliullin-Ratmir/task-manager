package ru.volnenko.se.command.project;

import ru.volnenko.se.command.AbstractCommand;

/**
 * @author Denis Volnenko
 */
public final class ProjectRemoveCommand extends AbstractCommand {

    @Override
    public String command() {
        return "project-remove";
    }

    @Override
    public String description() {
        return "Remove selected project.";
    }

    @Override
    public void execute() {

    }

}
