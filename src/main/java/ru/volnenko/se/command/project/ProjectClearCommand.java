package ru.volnenko.se.command.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import ru.volnenko.se.api.repository.IProjectRepository;
import ru.volnenko.se.api.service.IProjectService;
import ru.volnenko.se.command.AbstractCommand;

/**
 * @author Denis Volnenko
 */
@Component
@DependsOn("projectRepository")
public final class ProjectClearCommand extends AbstractCommand {

    private IProjectRepository projectRepository;
    @Autowired
    @Qualifier("projectRepository")
    public void setProjectRepository(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

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
        projectRepository.clear();
        System.out.println("[ALL PROJECTS REMOVED]");
    }

}
