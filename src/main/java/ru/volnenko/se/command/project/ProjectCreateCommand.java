package ru.volnenko.se.command.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.volnenko.se.CommandEvent;
import ru.volnenko.se.api.service.IProjectService;
import ru.volnenko.se.command.AbstractCommand;

/**
 * @author Denis Volnenko
 */
@Component
@DependsOn("projectService")
public final class ProjectCreateCommand extends AbstractCommand {

    private IProjectService projectService;
    @Autowired
    @Qualifier("projectService")
    public void setProjectService(IProjectService projectService) {
        this.projectService = projectService;
    }

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
        final String name = nextLine();
        projectService.createProject(name);
        System.out.println("[OK]");
        System.out.println();
    }

    @EventListener(condition = "#commandEvent.command.toLowerCase().contains('project-create')")
    public void onApplicationEvent(CommandEvent commandEvent) {
        execute();
    }

}
