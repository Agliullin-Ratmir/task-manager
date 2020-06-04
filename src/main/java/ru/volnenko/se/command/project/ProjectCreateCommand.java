package ru.volnenko.se.command.project;

import ru.volnenko.se.command.AbstractCommand;

/**
 * @author Denis Volnenko
 */
public final class ProjectCreateCommand extends AbstractCommand {

    @Override
    public String description() {
        return "Create new project.";
    }

    @Override
    public String command() {
        return "project-create";
    }

    @Override
    public void execute() {
        System.out.println("[PROJECT CREATE]");
        System.out.println("ENTER NAME:");
        final String name = bootstrap.nextLine();
        bootstrap.getProjectRepository().createProject(name);
        System.out.println("[OK]");
        System.out.println();
    }

}
