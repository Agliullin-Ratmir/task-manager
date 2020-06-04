package ru.volnenko.se.command.project;

import ru.volnenko.se.command.AbstractCommand;

/**
 * @author Denis Volnenko
 */
public final class ProjectClearCommand extends AbstractCommand {

    @Override
    public String command() {
        return "project-clear";
    }

    @Override
    public String description() {
        return "Remove all projects.";
    }

    @Override
    public void execute() {
        bootstrap.getProjectRepository().clear();
        System.out.println("[ALL PROJECTS REMOVED]");
    }

}
