package ru.volnenko.se.command.project;

import ru.volnenko.se.command.AbstractCommand;
import ru.volnenko.se.entity.Project;

/**
 * @author Denis Volnenko
 */
public final class ProjectListCommand extends AbstractCommand {

    @Override
    public String command() {
        return "project-list";
    }

    @Override
    public String description() {
        return "Show all projects.";
    }

    @Override
    public void execute() {
        System.out.println("[PROJECT LIST]");
        int index = 1;
        for (Project project: bootstrap.getProjectService().getListProject()) {
            System.out.println(index++ + ". " + project.getName());
        }
        System.out.println();
    }

}
