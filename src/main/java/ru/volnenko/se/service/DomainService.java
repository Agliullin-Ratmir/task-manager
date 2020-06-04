package ru.volnenko.se.service;

import ru.volnenko.se.api.service.IDomainService;
import ru.volnenko.se.api.service.ServiceLocator;
import ru.volnenko.se.entity.Domain;

/**
 * @author Denis Volnenko
 */
public final class DomainService implements IDomainService {

    private final ServiceLocator serviceLocator;

    public DomainService(final ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public void load(final Domain domain) {
        if (domain == null) return;
        serviceLocator.getProjectService().load(domain.getProjects());
        serviceLocator.getTaskService().load(domain.getTasks());
    }

    @Override
    public void export(final Domain domain) {
        if (domain == null) return;
        domain.setProjects(serviceLocator.getProjectService().getListProject());
        domain.setTasks(serviceLocator.getTaskService().getListTask());
    }

}
