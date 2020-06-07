package ru.volnenko.se.service;

import ru.volnenko.se.api.service.IDomainService;
import ru.volnenko.se.api.service.IProjectService;
import ru.volnenko.se.api.service.ITaskService;
import ru.volnenko.se.api.service.ServiceLocator;
import ru.volnenko.se.controller.Bootstrap;
import ru.volnenko.se.entity.Domain;

import java.util.logging.Logger;

/**
 * @author Denis Volnenko
 */
public final class DomainService implements IDomainService {

    private final IProjectService projectService;

    private final ITaskService taskService;

    public DomainService(IProjectService projectService, ITaskService taskService) {
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Override
    public void load(final Domain domain) {
        if (domain == null) return;
        projectService.load(domain.getProjects());
        taskService.load(domain.getTasks());
    }

    @Override
    public void export(final Domain domain) {
        if (domain == null) return;
        domain.setProjects(projectService.getListProject());
        domain.setTasks(taskService.getListTask());
    }

}
