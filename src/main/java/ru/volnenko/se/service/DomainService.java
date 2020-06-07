package ru.volnenko.se.service;

import ru.volnenko.se.api.service.IDomainService;
import ru.volnenko.se.api.service.ServiceLocator;
import ru.volnenko.se.controller.Bootstrap;
import ru.volnenko.se.entity.Domain;

import java.util.logging.Logger;

/**
 * @author Denis Volnenko
 */
public final class DomainService implements IDomainService {

    private static Logger log = Logger.getLogger(DomainService.class.getName());

    private ServiceLocator serviceLocator;

    public void setServiceLocator(ServiceLocator serviceLocator) {
        if (this.serviceLocator == null) {
            this.serviceLocator = serviceLocator;
        } else {
            log.info("The field serviceLocator is already setted!");
        }
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
